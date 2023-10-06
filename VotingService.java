
import java.util.List;
import java.util.ArrayList;

public class VotingService
{
	private Question question;
	private List<Student> studentAnswers = new ArrayList<>();

	/** VotingService Constructor, taking a given Question */
	public VotingService(Question question)
	{
		this.question = question;
	}

	/** Prints out the question and its potential answers */
	public void displayQuestion()
	{
		String[] questionLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
		System.out.println(question.getQuestionString());
		int i = 0;
		for (Answer choice : question.getAnswerChoices()) {
			System.out.printf("%s: %s", questionLabels[i], choice.getAnswerString());
			System.out.println();
			i++;
		}
	}

	/** Adds a Student to the list of studentAnswers */
	public void addStudentAnswers(Student student)
	{
		this.studentAnswers.add(student);
	}

	/** Private helper method that filters out the correct methods of all of the
	 * potential answers of the Question
	 */
	private List<Answer> filterCorrectAnswers()
	{
		List<Answer> correctAnswers = new ArrayList<>();
		for (Answer choice : question.getAnswerChoices()) {
			if (choice.isCorrect()) {
				correctAnswers.add(choice);
			}
		}
		return correctAnswers;
	}

	/** Private helper method returning a boolean,
	 * comparing the answers of the Student to the correct answers of the Question
	 */
	private boolean compareAnswers(Student student)
	{
		boolean isCorrect = true;
		List<Answer> correctAnswers = filterCorrectAnswers();
		List<Answer> studentAnswers = student.getAnswerSelections();
		if (studentAnswers.size() != correctAnswers.size()) {
			isCorrect = false;
		}
		else {
			for (int i = 0; i < studentAnswers.size(); i++) {
				if ((studentAnswers.get(i).isCorrect() && !correctAnswers.get(i).isCorrect()) || (!studentAnswers.get(i).isCorrect() && correctAnswers.get(i).isCorrect())) {
					isCorrect = false;
				}
			}
		}

		return isCorrect;
	}

	/** Prints out the correct answer, and the number of students right and wrong */
	public void displayStats()
	{
		int correct = 0;
		int incorrect = 0;
		for (Student s : studentAnswers) {
			if (compareAnswers(s)) {
				correct++;
			}
			else if (!compareAnswers(s)) {
				incorrect++;
			}
		}
		System.out.println("The correct answer is: " + filterCorrectAnswers().toString());
		System.out.println("Right: " + correct + " Wrong: " + incorrect);
	}
}
