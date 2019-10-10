package bridge;

import java.util.List;

public class PrintFormatter implements Formatter {
	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		builder.append(System.lineSeparator());

		for (Detail detail : details) {
			builder
					.append(detail.getLabel())
					.append(":")
					.append(detail.getValue())
					.append(System.lineSeparator());
		}
		return builder.toString();
	}
}
