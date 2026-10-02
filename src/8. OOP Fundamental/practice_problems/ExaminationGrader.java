
import java.util.Scanner;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double gradeAnswer();
}

class MCQ extends Question {
    MCQ(String questionText, String correctAnswer,
        String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double gradeAnswer() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TF extends Question {
    TF(String questionText, String correctAnswer,
       String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double gradeAnswer() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    Essay(String questionText, String correctAnswer,
          String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double gradeAnswer() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String questionText = sc.next();
            String correctAnswer = sc.next();
            String studentAnswer = sc.next();
            double points = sc.nextDouble();

            questionText = questionText.substring(
                1, questionText.length() - 1);
            correctAnswer = correctAnswer.substring(
                1, correctAnswer.length() - 1);
            studentAnswer = studentAnswer.substring(
                1, studentAnswer.length() - 1);

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(questionText, correctAnswer,
                                       studentAnswer, points);
                    break;

                case "TF":
                    question = new TF(questionText, correctAnswer,
                                      studentAnswer, points);
                    break;

                case "ESSAY":
                    question = new Essay(questionText, correctAnswer,
                                         studentAnswer, points);
                    break;

                default:
                    continue;
            }

            double score = question.gradeAnswer();

            System.out.printf("%s: %.2f%n", type, score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}
