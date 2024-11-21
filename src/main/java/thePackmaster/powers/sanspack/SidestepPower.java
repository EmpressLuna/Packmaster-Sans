package thePackmaster.powers.sanspack;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class SidestepPower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("SidestepPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public SidestepPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, true, owner, amount);
    }

    public float atDamageFinalReceive(float damage, DamageInfo.DamageType type) {
        flash();
        float reduction = type == DamageInfo.DamageType.NORMAL ? 0 : damage;
        amount--;
        if (amount == 0) {
            removeThis();
        } else {
            updateDescription();
        }
        return reduction;
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        this.flash();
        return damageAmount;
    }

    @Override
    public void atStartOfTurnPostDraw() {
        flash();
        amount--;
        if (amount == 0) {
            removeThis();
        } else {
            updateDescription();
        }
    }
}
