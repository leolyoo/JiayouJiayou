package leolyoo.jiayoujiayou

class WordQuizManager(words: List<Word>, private val listener: Listener) {

    interface Listener {
        fun onUpdate(
            life: Int,
            countRemaining: Int,
            question: String,
            choice1: String,
            choice2: String,
            choice3: String,
            choice4: String
        )

        fun onCorrect()
        fun onWrong()
        fun onPass(countWrong: Int)
        fun onFail()
    }

    private val wordQuizzes = mutableListOf<WordQuiz>()

    var life = 3
    var countCorrect = 0
    var countWrong = 0
    private lateinit var wordQuiz: WordQuiz

    init {
        for (answer in words) {
            val list = words.filterNot { it.meaning == answer.meaning }.shuffled()

            // 주어진 한자의 뜻 맞추기
            var choices = mutableListOf<String>()
            list.map { it.meaning }.distinct().forEach {
                if (choices.size < 3)
                    choices.add(it)
            }
            choices.add(answer.meaning)
            while (choices.size < 4)
                choices.add(ERROR)
            choices.shuffle()

            wordQuizzes.add(
                WordQuiz(
                    question = answer.character,
                    answer = answer.meaning,
                    choice1 = choices[0],
                    choice2 = choices[1],
                    choice3 = choices[2],
                    choice4 = choices[3]
                )
            )

            // 주어진 뜻을 가진 한자 맞추기
            choices = mutableListOf()
            list.map { it.character }.distinct().forEach {
                if (choices.size < 3)
                    choices.add(it)
            }
            choices.add(answer.character)
            while (choices.size < 4)
                choices.add(ERROR)
            choices.shuffle()

            wordQuizzes.add(
                WordQuiz(
                    question = answer.meaning,
                    answer = answer.character,
                    choice1 = choices[0],
                    choice2 = choices[1],
                    choice3 = choices[2],
                    choice4 = choices[3]
                )
            )
        }

        wordQuizzes.shuffle()
        while (wordQuizzes.size > 10)
            wordQuizzes.removeAt(0)

        nextQuiz()
    }

    private fun nextQuiz() {
        if (wordQuizzes.isNotEmpty() && life > 0) {
            wordQuiz = wordQuizzes.removeAt(0)
            listener.onUpdate(
                life,
                wordQuizzes.size,
                wordQuiz.question,
                wordQuiz.choice1,
                wordQuiz.choice2,
                wordQuiz.choice3,
                wordQuiz.choice4
            )
        } else if (wordQuizzes.isEmpty() && life > 0)
            listener.onPass(countWrong)
        else
            listener.onFail()
    }

    fun choose(index: Int) {
        when (index) {
            1 -> check(wordQuiz.choice1)
            2 -> check(wordQuiz.choice2)
            3 -> check(wordQuiz.choice3)
            4 -> check(wordQuiz.choice4)
        }
    }

    private fun check(choice: String) {
        if (wordQuiz.answer != choice) {
            life--
            countWrong++
            listener.onWrong()
        } else {
            countCorrect++
            listener.onCorrect()
        }
        nextQuiz()
    }


}