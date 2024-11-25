package thePackmaster.actions.sanspack;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.AnimateJumpAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class SidestepAction extends AbstractGameAction{

    private String powerID;
    private AbstractPower powerInstance;

    public SidestepAction(AbstractCreature target, AbstractCreature source, String power, int amount) {
        this.setValues(target, source, amount);
        if (Settings.FAST_MODE) {
            this.duration = this.startDuration = Settings.ACTION_DUR_XFAST;
        } else {
            this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
        }

        this.powerID = power;
        this.actionType = AbstractGameAction.ActionType.REDUCE_POWER;
    }

    public SidestepAction(AbstractCreature target, AbstractCreature source, AbstractPower powerInstance, int amount) {
        this.setValues(target, source, amount);
        if (Settings.FAST_MODE) {
            this.duration = this.startDuration = Settings.ACTION_DUR_XFAST;
        } else {
            this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
        }

        this.powerInstance = powerInstance;
        this.actionType = AbstractGameAction.ActionType.REDUCE_POWER;
    }

    public void update() {
        float vY = 500.0F * Settings.scale;
        float animationTimer = 200;
        if (this.duration == this.startDuration) {
            AbstractPower reduceMe = null;
            if (this.powerID != null) {
                reduceMe = this.target.getPower(this.powerID);
            } else if (this.powerInstance != null) {
                reduceMe = this.powerInstance;
            }

            if (reduceMe != null) {

                //while (animationTimer > 0) {
                //    vY -= 17.0F * Settings.scale;
                //    target.animY += vY * Gdx.graphics.getDeltaTime();
                //    if (target.animY < 0.0F) {
                //        animationTimer = 0.0F;
                //        target.animY = 0.0F;
                //    }
                //}
                AbstractDungeon.player.useStaggerAnimation();

                if (this.amount < reduceMe.amount) {
                    reduceMe.reducePower(this.amount);
                    reduceMe.updateDescription();
                    AbstractDungeon.onModifyPower();
                } else {
                    this.addToTop(new RemoveSpecificPowerAction(this.target, this.source, reduceMe));
                }
            }
        }

        this.tickDuration();
    }
}
