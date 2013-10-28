CREATE TEMPORARY TABLE IF NOT EXISTS node (
  id bigint(20) NOT NULL,
  lat varchar(20) NOT NULL,
  lon varchar(20) NOT NULL
) ENGINE=MEMORY DEFAULT CHARSET=utf8;

CREATE TEMPORARY TABLE IF NOT EXISTS tag (
  k varchar(255) NOT NULL,
  v varchar(255) NOT NULL,
  id bigint(20) NOT NULL
) ENGINE=MEMORY DEFAULT CHARSET=utf8;

LOAD XML LOCAL INFILE './cities.osm'
    INTO TABLE tag
    ROWS IDENTIFIED BY '<tag>';
LOAD XML LOCAL INFILE './cities.osm'
    INTO TABLE node
    ROWS IDENTIFIED BY '<node>';

DROP TABLE IF EXISTS cities;
CREATE TABLE IF NOT EXISTS cities (
  osm_id bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
  place varchar(255) NOT NULL,
  lat float NOT NULL,
  lon float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cities (osm_id, name, place, lat, lon)
(
	SELECT t.id AS osm_id, name, place, lat, lon
	FROM (
		SELECT id,
			GROUP_CONCAT(if(k = 'name', lower(v), NULL)) AS name,
			GROUP_CONCAT(if(k = 'place', lower(v), NULL)) AS place
		FROM tag
		WHERE (
			k = 'place' AND v IN ('city', 'town', 'village', 'hamlet')
		) OR k = 'name'
		GROUP BY id
	) t
	JOIN node AS n
	ON n.id = t.id
	WHERE place IS NOT NULL AND name IS NOT NULL
);
