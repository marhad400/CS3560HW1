import java.util.Random;

public class SimulationDriver
{
	/** Main program that initializes all of the Questions and Answers,
	 * and runs the VotingService through all of the Questions
	 */
	public static void main(String[] args)
	{
		Question q1 = new MultipleChoiceQuestion("What are the 3 primary colors?");
		Answer a1 = new Answer("Red", true);
		Answer b1 = new Answer("Orange", false);
		Answer c1 = new Answer("Yellow", true);
		Answer d1 = new Answer("Green", false);
		Answer e1 = new Answer("Blue", true);
		Answer f1 = new Answer("Purple", false);
		q1.addChoice(a1);
		q1.addChoice(b1);
		q1.addChoice(c1);
		q1.addChoice(d1);
		q1.addChoice(e1);
		q1.addChoice(f1);

		Question q2 = new SingleChoiceQuestion("When was the Declaration of Independece signed?");
		Answer a2 = new Answer("1776", true);
		Answer b2 = new Answer("1812", false);
		Answer c2 = new Answer("1767", false);
		Answer d2 = new Answer("1941", false);
		q2.addChoice(a2);
		q2.addChoice(b2);
		q2.addChoice(c2);
		q2.addChoice(d2);

		Question q3 = new MultipleChoiceQuestion("Who races for the Scuderia Ferrari F1 team?");
		Answer a3 = new Answer("Lewis Hamilton", false);
		Answer b3 = new Answer("Charles Leclerc", true);
		Answer c3 = new Answer("Carlos Sainz", true);
		Answer d3 = new Answer("Lando Norris", false);
		q3.addChoice(a3);
		q3.addChoice(b3);
		q3.addChoice(c3);
		q3.addChoice(d3);

		Random rand = new Random();
		int numStudents = rand.nextInt(30 - 15) + 15;
		Student[] students = generateStudents(numStudents);

		Question[] questions = {q1, q2, q3};
		for (Question question : questions) {
			students = generateAnswers(students, question);

			VotingService iVote = new VotingService(question);
			iVote.displayQuestion();

			for (int i = 0; i < students.length; i++) {
				iVote.addStudentAnswers(students[i]);
			}

			iVote.displayStats();
			System.out.println();
		}
	}

	/** Private helper method to generate a number of students used in the VotingService loop */
	private static Student[] generateStudents(int numStudents)
	{
		Student[] students = new Student[numStudents];
		for (int i = 0; i < numStudents; i++) {
			students[i] = new Student();
		}
		return students;
	}

	/** Private helper method to generate a random number of Answers for a Question, for each of the Students */
	private static Student[] generateAnswers(Student[] students, Question question)
	{
		Random rand = new Random();
		if (!question.isMultipleChoice()) {
			for (int i = 0; i < students.length; i++) {
				students[i].addAnswer(question.getAnswerChoices().get(rand.nextInt(question.getAnswerChoices().size())));
			}
		}
		else if (question.isMultipleChoice()) {
			for (int i = 0; i < students.length; i++) {
				int amountSelected = rand.nextInt(question.getAnswerChoices().size());
				for (int j = 0; j < amountSelected + 1; j++) {
					int selector = rand.nextInt(question.getAnswerChoices().size());
					if (i == selector) {
						students[i].addAnswer(question.getAnswerChoices().get(i));
					}
				}
			}
		}
		return students;
	}
}
