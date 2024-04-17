E2E тест-сценарий (позитивный)

Добавление и оформление товара

Тестовые данные :

тестовый юзернейм = standard_user

тестовый пароль = secret_sauce

Шаги выполнения :

1. Открыть сайт https://www.saucedemo.com
2. Ввести тестовый юзернейм в поле Username
3. Ввести тестовый пароль в поле Password
4. Нажать на кнопку Login
5. Нажать на кнопку Add to cart у товара из списка
6. Перейти в Корзину
7. Нажать на кнопку Checkout
8. Ввести корректные данные в поле First Name (e.g. Michael)
9. Ввести корректные данные в поле Last Name (e.g. Williams)
10. Ввести корректные данные в поле Zip/Postal Code(e.g. 53821)
11. Нажать на кнопку Continue
12. Нажать на кнопку Finish

Ожидаемый результат :

Переход на страницу https://www.saucedemo.com/checkout-complete.html

Отображаются следующие элементы :

*Тайтл страницы: "Checkout: Complete!"

*Текст страницы (header): "Thank you for your order!"

*Сообщение на странице: "Your order has been dispatched, and will arrive just as fast as the pony can get there!"

*Кнопка: Back Home