# spring-microservice

When you deploy your microservices for the first time, the first hurdle that you come across is how do they two talk to each other. 

This project has three Spring Boot Applications which communicates with other to return us the final output.
`movie-catalogue-service` talks to `movie-info-service` and `ratings-service`, and then consolidate the data and give back to the caller.

To do so what we need:
1. Three microservice with REST endpoints
2. A discovery server (Netflix Eureka in our case)
3. Register all microservices with discovery server

Note: Service discovery might also be done with k8's and for that you will be needing 'deployment' files. 
For more on this, look at this article https://dzone.com/articles/k8s-knowhow-service-discovery-and-networking


