module.exports = () => {
	const data = {
		"quizzes": [
			{
				"id": 1,
				"name": "Cars",
				"questions": [
					{
						"text": "which automaker is known for producing the Mustang",
						"correct-answer": "Ford",
						"answers": ["Chevrolet", "Ford", "Dodge", "Toyota"]
					},
					{
						"text": "which type of engine is most commonly used in hybrid cars?",
						"correct-answer": "Hybrid",
						"answers": ["V8", "Diesel", "Electric", "Hybrid"]
					},
					{
						"text":"which car model is the best-selling of all times?",
						"correct-answer":"Toyota Corolla",
						"answers":["Toyota Corolla","Honda Civic","Ford F-Series","Volkswagen Golf"]
					}
				]
			}
		]
	};
	return data
}
