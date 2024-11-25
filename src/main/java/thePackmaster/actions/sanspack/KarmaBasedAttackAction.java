package thePackmaster.actions.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import thePackmaster.powers.sanspack.KarmaPower;

import static thePackmaster.util.Wiz.att;

public class KarmaBasedAttackAction extends AbstractGameAction {
    private AbstractCreature m;
    private AbstractCreature p;
    private int magicNumber;

    public KarmaBasedAttackAction(AbstractCreature target, AbstractCreature source, int magicNumber) {
        m = target;
        p = source;
        this.magicNumber = magicNumber;
    }

    @Override
    public void update() {
        int numberOfAttacks = 0;

        if (m.hasPower(KarmaPower.POWER_ID)) {
            numberOfAttacks = m.getPower(KarmaPower.POWER_ID).amount;
        }

        for (int i = 0; i < numberOfAttacks * magicNumber; i++) {
            att(new DamageAction(m, new DamageInfo(source, 1, DamageInfo.DamageType.NORMAL),
                    AbstractGameAction.AttackEffect.SLASH_HORIZONTAL, true));
        }

        this.isDone = true;
    }
}
