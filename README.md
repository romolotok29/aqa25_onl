1. Обновить версии всех библиотек в проекте

-- проверка доступных обновлений :

mvn versions:display-dependency-updates

Вывод :

The following dependencies in Dependencies have newer versions:
[INFO]   io.github.bonigarcia:webdrivermanager ................. 5.7.0 -> 5.8.0
[INFO]   org.seleniumhq.selenium:selenium-java ............... 4.18.1 -> 4.20.0
[INFO]   org.testng:testng .................................... 7.7.0 -> 7.10.2

-- обновление библиотек :

mvn versions:use-latest-versions

Вывод :

[INFO] Updated org.testng:testng:jar:7.7.0 to version 7.10.2
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:4.18.1 to version 4.20.0
[INFO] Updated io.github.bonigarcia:webdrivermanager:jar:5.7.0 to version 5.8.0


2. Запустить тесты используя mvn clean test команду и ее вывод

mvn clean -DlockedUserName=locked_out_user test

Вывод : 

[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.31 s -- in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

3. Использовать параметры для запуска конкретных тестов и методов

mvn clean test -DsuiteXmlFile=src/test/resources/parallel


Вывод :

[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.538 s -- in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS


4. Пробросить параметр из mvn command line внутрь теста

mvn clean -DlockedUserName=locked_out_user -Dtest=AdditionalTests#loginAsLockedUserTest test

Вывод :

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.159 s -- in tests.AdditionalTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

