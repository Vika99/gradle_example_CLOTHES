plugins {
     java
}

group ="jetbrains"
version ="1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(group="org.junit.jupiter", name="junit-jupiter-engine", version="5.6.2")
    testImplementation("org.mockito:mockito-core:3.1.0")
}

configure<JavaPluginConvention>{
    sourceCompatibility = JavaVersion.VERSION_13
}
tasks.withType<Jar>{
      manifest{
          attributes ["Main-Class"]="ProjectClothes.MenuWithGeneric.MainMenuGeneric"
    }
}

