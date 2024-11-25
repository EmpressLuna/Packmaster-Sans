package thePackmaster.actions.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.util.Wiz;

public class GainTempStrengthAction extends AbstractGameAction {
    private AbstractCreature p;
    private int amount;

    public GainTempStrengthAction(AbstractCreature player, int amount) {
        this.p = player;
        this.amount = amount;
    }

    @Override
    public void update() {
        Wiz.applyToSelf(new StrengthPower(p, amount));
        Wiz.applyToSelf(new LoseStrengthPower(p, amount));
        this.isDone = true;
    }
}
