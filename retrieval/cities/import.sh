#!/bin/bash

USER='root'
DB='hochwasser'

echo "Query Overpass-API"
curl -X POST -d @cities.opql -o cities.osm http://overpass-api.de/api/interpreter || exit 1

echo "Start import to mysql"
mysql -u"$USER" $DB --local-infile < import_osm_cities.sql