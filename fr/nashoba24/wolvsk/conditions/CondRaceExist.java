package fr.nashoba24.wolvsk.conditions;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import org.bukkit.event.Event;

import fr.nashoba24.wolvmc.WolvMC;

public class CondRaceExist extends Condition {

    private Expression<String> race;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
        race = (Expression<String>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "If a race exist";
    }

    @Override
    public boolean check(Event e) {
        if(WolvMC.raceExist(race.getSingle(e))) {
        	return true;
        }
        else {
        	return false;
        }
    }

}