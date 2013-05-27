// environment specific settings
environments {
    development {
        grails {          
            mongo {
                host = "localhost"
                port = 27017
                username = ""
                password=""
                databaseName = "basketnews"
            }
        }

    }

    production {
        grails {

            mongo {
                host = "localhost"
                port = 27017
                username = ""
                password=""
                databaseName = "basketnews"
            }
        }


    }
}
