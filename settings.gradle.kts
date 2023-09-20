rootProject.name = "minibank-microservices"
include("common")
include("services:cards-service")
findProject(":services:cards-service")?.name = "cards-service"
