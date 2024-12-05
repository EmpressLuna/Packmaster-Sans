package thePackmaster.powers.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import thePackmaster.actions.sanspack.KarmaDamageAction;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class KarmaPower extends AbstractPackmasterPower {

    public static final String POWER_ID = makeID("KarmaPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;
    private AbstractCreature source;

    public KarmaPower(AbstractCreature owner, AbstractCreature source, int amount) {
        super(POWER_ID, NAME, PowerType.DEBUFF, true, owner, amount);
        this.source = source;
    }

    public void atStartOfTurn() {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flashWithoutSound();
            this.addToBot(new KarmaDamageAction(this.owner, this.source, this.amount, AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        }
    }

    @Override
    public void atEndOfRound() {
        this.addToTop(new ReducePowerAction(this.owner, this.owner, this.ID, 1));
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
