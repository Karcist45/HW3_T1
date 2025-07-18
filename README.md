# Homework №3 from it-camp by T1
### Project structure:
1) synthetic-human-core-starter - the library, autoconfigurates via StarterAutoConfiguration class
2) bishop-prototype - uses the library to provide endpoinds for manual testing/showcase 
### To run:
1) Put your ip-address in prometheus.yml (you can learn you ip address with ipconfig command on windows)
2) run docker-compose up from project directory
3) turn on Spring Boot Application in project-bishop

You can change where WeylandWatchingYou annotation writes its log through **application.yml**. There are currently 2 mods:
1) CONSOLE - writes in console
2) KAFKA - sends to kafka (kafka listener is in project to demonstrate that the message made it to the consumer)