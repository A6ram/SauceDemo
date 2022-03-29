
1.Проверка обновлений для зависимостей: mvn version:display-dependency-updates

Результат: [INFO] The following dependencies in Dependencies have newer versions: [INFO] org.seleniumhq.selenium:selenium-java 3.141.59 -> 4.1.2

2.Обновление зависимостей: mvn versions:use-latest-versions
Результат: Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.1.2

3.Запуск тестов: mvn clean test ####Результат: Tests run: 15, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 88.728 sec

4.Запуск конкретного теста:mvn test -Dtest=InfoUserTest

5.Запуск конкретного метода из теста:  mvn test -Dtest=InfoUserTest#allFieldShouldBeRequired

6.Запуск нескольких конкретных методов из теста:  mvn test -Dtest=InfoUserTest#allFieldShouldBeRequired+zipCodeShouldByRequired