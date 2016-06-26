package fr.nashoba24.wolvsk.conditions;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import org.bukkit.Location;
import org.bukkit.event.Event;

import fr.nashoba24.wolvmc.WolvMC;

public class CondCanUseSafePower extends Condition {


    private Expression<Location> loc;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
        loc = (Expression<Location>) expr[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "If a player can use a power that don't moves block";
    }

    @Override
    public boolean check(Event e) {
        if(WolvMC.canUsePowerSafe(loc.getSingle(e))) {
        	return true;
        }
        else {
        	return false;
        }
    }

}