package Print;

abstract class TimeUtils {
	public static String convertTime(long milliseconds) {
		long hour = milliseconds / (3600 * 1000);
		int millis = (int) milliseconds % 1000;
		int minute = (int) (milliseconds - hour * 3600 * 1000) / (60 * 1000);
		int second = (int) (milliseconds - hour * 3600 * 1000 - minute * 60 * 1000) / 1000;
		return hour + " hour(s) " + minute + " minute(s) " + second + " second(s) " + millis + " milliseconds";
	}
}
