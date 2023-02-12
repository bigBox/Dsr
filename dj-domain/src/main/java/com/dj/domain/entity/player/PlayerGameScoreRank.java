package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.meetEgg.PlayerScoreRank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerGameScoreRank extends BaseEntity implements Comparable{
	private static final long serialVersionUID = -2235262471881600675L;

	public PlayerGameScoreRank(long roleID) {
		super(roleID);
	}

	private long score;

	private String roleName;

	@Override
	public IEntity copy() {
		PlayerGameScoreRank playerGameScoreRank = new PlayerGameScoreRank();
		copySuper(playerGameScoreRank);
		return playerGameScoreRank;
	}

	public PlayerScoreRank toPlayerScoreRank(int rankId) {
		PlayerScoreRank.Builder builder = PlayerScoreRank.newBuilder();
		builder.setRankId(rankId);
		builder.setRoleId(roleID);
		builder.setName(roleName);
		builder.setScore(score);
		return builder.build();
	}

	@Override
	public int compareTo(@NotNull Object o) {
		if(o instanceof PlayerGameScoreRank){
			PlayerGameScoreRank s = (PlayerGameScoreRank)o;
			if(this.score > s.score){
				return 1;
			}
			else{
				return 0;
			}
		}
		return -1;
	}
}