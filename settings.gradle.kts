rootProject.name = "minibank-microservices"
include("common")
include("services:cards-service")
include("services:loans-service")
include("services:accounts-service")
include("services:eureka-server")
include("services:gateway-server")
findProject(":services:cards-service")?.name = "cards-service"
findProject(":services:loans-service")?.name = "loans-service"
findProject(":services:accounts-service")?.name = "accounts-service"
findProject(":services:eureka-server")?.name = "eureka-server"
findProject(":services:gateway-server")?.name = "gateway-server"
