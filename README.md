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

Find all distinct predators of rat (*Rattus rattus*): http://46.4.36.142:8080/prey/Rattus%20rattus/listPredators

Find all distinct prey of humans (*Homo sapiens*): http://46.4.36.142:8080/predator/Homo%20sapiens/listPrey

Find available taxa with known interactions starting with Ario: http://46.4.36.142:8080/findTaxon/Ario

Find all predator observations that ate blue crab (*Callinectes sapidus*): http://46.4.36.142:8080/prey/Callinectes%20sapidus/listPredatorObservations/

Find prey for observations of predator hardhead catfish (*Ariopsis felis*): http://46.4.36.142:8080/predator/Ariopsis%20felis/listPreyObservations/





