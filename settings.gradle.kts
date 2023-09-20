rootProject.name = "minibank-microservices"
include("common")
include("services:cards-service")
include("services:loans-service")
include("services:eureka-server")
findProject(":services:cards-service")?.name = "cards-service"
findProject(":services:loans-service")?.name = "loans-service"
findProject(":services:eureka-server")?.name = "eureka-server"

