#!/bin/bash -x
if [[ "${PORT}" -gt 0 && "${PORT}" -lt 65535 ]] ; then
    echo "Setting kraken port to ${PORT}"
    jq ".port |= ${PORT}"  kraken-example-config.json > kraken-config.json
else
    cp kraken-example-config.json kraken-config.json
fi
./krakend run --config kraken-config.json
