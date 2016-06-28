package fr.nashoba24.wolvsk.expressions;

import javax.annotation.Nullable;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

import com.wasteofplastic.askyblock.ASkyBlockAPI;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprASkyBlockOwner extends SimpleExpression<OfflinePlayer>{
	private Expression<Location> loc;
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
	@Override
	public Class<? extends OfflinePlayer> getReturnType() {
		return OfflinePlayer.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		loc = (Expression<Location>) expr[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean paramBoolean) {
		return "asb owner of island";
	}
	
	@Override
	@Nullable
	protected OfflinePlayer[] get(Event e) {
		return new OfflinePlayer[]{ fr.nashoba24.wolvsk.Main.getInstance().getServer().getOfflinePlayer(ASkyBlockAPI.getInstance().getOwner(loc.getSingle(e))) };
	}
}

