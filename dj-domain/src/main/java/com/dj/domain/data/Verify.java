package com.dj.domain.data;

import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.verify.VerifyItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Verify {

	private int itemID;

	private int source;

	private long time;

	public VerifyItem toVerifyItem(VerifyItem.Builder builder){
		builder.setItemId(itemID);
		builder.setSource(source);
		builder.setTime(DateTime.newBuilder().setValue(time).build());
		return builder.build();
	}
}
