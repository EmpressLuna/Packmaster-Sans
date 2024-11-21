package thePackmaster.powers.sanspack;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class JudgementPower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("JudgementPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public JudgementPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, false, owner, amount);
    }

    public void atStartOfTurnPostDraw() {
        flash();
        owner.addPower(new SidestepPower(owner, 1));
    }
}
