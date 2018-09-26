Написать web приложение на Spring Boot, котороe через REST endpoint будет позволять искать в логфайле.

* Путь endpoint /api/search, тип GET
* Параметр в котором передается строка для поиска - q
* Ответ должен быть в JSON и содержать строки всех полных совподений и положение их файла и кол-во найденых результатов
* Код должен быть покрыть тестами

Пример:
Запрос - /api/search?q=error
Ответ - "{
	"results": [{
			"linenumber": 50,
			"value": "10:10:10 error: text text text"
		},
		{
			"linenumber": 140,
			"value": "10:10:10 error: text text text"
		},
		{
			"linenumber": 550,
			"value": "10:10:10 error: text text text"
		}
	],
	"count": 3
}"
