Feature: Тестируем Google
  Проверяем наличие ссылки на Википедию в результатах поиска

  @gladiolus
  Scenario Outline: Проверка поиска
    Given перейти на сайт 'https://www.google.com/'
    When ищем <слово> на сайте <сайт> в результатах поиска
    Then закончить работу

    Examples:
      | слово     | сайт      |
      | Гладиолус | Википедия |
