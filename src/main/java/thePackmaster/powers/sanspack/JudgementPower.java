package thePackmaster.powers.sanspack;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.util.Wiz;

import java.util.Random;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class JudgementPower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("JudgementPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public JudgementPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, false, owner, amount);
    }

    public void atStartOfTurnPostDraw() {
        Wiz.applyToSelf(new SidestepPower(Wiz.p(), 1));
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                Wiz.applyToSelf(new StrengthPower(Wiz.p(), -1));
                break;
            case 1:
                Wiz.applyToSelf(new DexterityPower(Wiz.p(), -1));
                break;
            case 2:
                Wiz.applyToSelf(new FocusPower(Wiz.p(), -1));
                break;
        }
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
    }
}
