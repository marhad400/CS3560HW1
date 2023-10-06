import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Student
{
	private UUID studentID;
	private List<Answer> answerSelections;

	/** Student constructor, sets a random, unique ID and a new ArrayList of answer selections */
	public Student()
	{
		setID(UUID.randomUUID());
		answerSelections = new ArrayList<>();
	}

	/** Student ID setter method */
	public void setID(UUID studentID)
	{
		this.studentID = studentID;
	}

	/** Student ID getter method */
	public UUID getID()
	{
		return studentID;
	}

	/** Adds an answer to the list of answerSelections */
	public void addAnswer(Answer answer)
	{
		answerSelections.add(answer);
	}

	/** Returns the List of answerSelections */
	public List<Answer> getAnswerSelections()
	{
		return answerSelections;
	}
}
