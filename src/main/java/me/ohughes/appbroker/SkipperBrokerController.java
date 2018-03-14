package me.ohughes.appbroker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.skipper.domain.PackageMetadata;
import org.springframework.cloud.skipper.domain.UploadRequest;
import org.springframework.cloud.skipper.server.service.PackageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkipperBrokerController {

	@Autowired
	PackageService packageService;

	@RequestMapping("/upload")
	public PackageMetadata uploadPackage(@RequestParam(name = "packagePath") String packagePath) throws IOException {
		UploadRequest uploadRequest = new UploadRequest();

		String fileName = Paths
				.get(packagePath)
				.getFileName()
				.toString()
				.replaceFirst("[.][^.]+$", "");

		uploadRequest.setName(fileName);
		uploadRequest.setExtension(packagePath.substring(packagePath.lastIndexOf(".") + 1));
		uploadRequest.setPackageFileAsBytes(Files.readAllBytes(Paths.get(packagePath)));
		uploadRequest.setRepoName("local");
		uploadRequest.setVersion("0.0.1");
		return packageService.upload(uploadRequest);
	}
}
