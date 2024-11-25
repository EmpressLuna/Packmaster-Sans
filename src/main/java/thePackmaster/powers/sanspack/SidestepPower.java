package thePackmaster.powers.sanspack;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import thePackmaster.actions.sanspack.SidestepAction;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class SidestepPower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("SidestepPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public SidestepPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, true, owner, amount);
    }

    @Override
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        if (damageAmount > 0) {
            this.addToTop(new SidestepAction(this.owner, this.owner, this.ID, 1));
        }
        return 0;
    }

    @Override
    public void atEndOfRound() {
        this.addToTop(new ReducePowerAction(this.owner, this.owner, this.ID, this.amount));
    }

    @Override
    public void updateDescription() {
        if (amount == 1){
            this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
        }
        else {
            this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[2];
        }
    }
}
