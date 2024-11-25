package thePackmaster.powers.sanspack;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import thePackmaster.actions.sanspack.GainTempStrengthAction;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class EncirclePower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("EncirclePower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public EncirclePower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.DEBUFF, false, owner, amount);
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (damageAmount > 0 && info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner) {
            this.flash();
            this.addToTop(new GainTempStrengthAction(AbstractDungeon.player, this.amount));
        }
        return damageAmount;
    }

    @Override
    public void atEndOfRound() {
        this.addToTop(new ReducePowerAction(this.owner, this.owner, this.ID, 1));
    }

    @Override
    public void updateDescription() {
        if (amount == 1){
            this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
        }
        else {
            this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount + DESCRIPTIONS[3];
        }
    }
}
