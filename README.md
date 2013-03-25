eol-globi-rest
==============

Standalone server that provides RESTful interface to EOL's Global Biotic Interactions datasets.

# Prequisites
java, maven

# Install / Run 

git clone git://github.com/jhpoelen/eol-globi-rest.git

cd eol-globi-rest

mvn clean install 

java -jar target/dependency/jetty-runner.jar --port 8080 target/*.war

#Try our test server

## Examples

Find predators of rat: http://46.4.36.142:8080/prey/Rattus%20rattus/listPredators

Find prey of humans: http://46.4.36.142:8080/predator/Homo%20sapiens/listPrey

Find available taxa with known interactions starting with Ario: http://46.4.36.142:8080/findTaxon/Ario







