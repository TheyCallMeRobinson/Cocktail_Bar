# Cocktail_Bar
Surf Summer School'23 Practice

1. Реализованные фичи:
   - Экраны:
     - Экран "Мои коктейли" и просмотр подробной информации по тапу на иконку коктейля
     - Экран приветствия, когда нет сохраненных коктейлей
     - Экран с подробной информацией по коктейлям
     - Экран создания новой записи коктейля
   - Архитектура:
     - Single Activity
     - Clean Architecture (разделил на Presentation, Domain, Data слои)
     - MVVM
   - Функционал:
     - Возможность сохранения списка ингредиентов в базе данных
     - Возможность добавлять кастомную картинку для коктейля
     - Валидатор для экрана создания записи коктейля (Это не много, но это честная работа)
3. Нереализованные фичи:
   - Добавление ингредиентов (тем не менее, они могут нормально храниться :) )
   - Шаринг списка коктейлей
   - Удаление коктейля
   - Изменение коктейля
   - Контейнер для FAB
4. Технические детали реализации:
   - Koin Dependency Injector
   - Room Database Storage
   - Kotlin Coroutines
   - AndroidX Navigation
   - GSON для конвертации списка ингредиентов и хранения его в бд

![Экран приветствия при пустом списке](app/src/main/res/screenshots/Empty_list_welcome_screen.jpg)
![Создание новой записи коктейля](app/src/main/res/screenshots/New_cocktail_creation.jpg)
![Валидация пустого названия коктейля](app/src/main/res/screenshots/Empty_title_validation.jpg)
![Экран "Мои коктейли"](app/src/main/res/screenshots/My_cocktails_list.jpg)
![Подробная информация о коктейле](https://github.com/TheyCallMeRobinson/Cocktail_Bar/blob/master/app/src/main/res/screenshots/Cocktail_info_details.jpg)
