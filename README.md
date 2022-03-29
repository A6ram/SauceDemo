
Проверка обновлений для зависимостей: mvn version:display-dependency-updates
Результат: [INFO] The following dependencies in Dependencies have newer versions: [INFO] org.seleniumhq.selenium:selenium-java 3.141.59 -> 4.1.2

Обновление зависимостей: mvn versions:use-latest-versions
Результат: Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.1.2

Запуск тестов: mvn clean test ####Результат: Tests run: 15, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 88.728 sec

Запуск конкретного теста:mvn test -Dtest=InfoUserTest
Запуск конкретного метода из теста:  mvn test -Dtest=InfoUserTest#allFieldShouldBeRequired
Запуск нескольких конкретных методов из теста:  mvn test -Dtest=InfoUserTest#allFieldShouldBeRequired+zipCodeShouldByRequired
