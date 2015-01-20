/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

/**
 *
 * @author hansolo
 */
public enum WeatherSymbols
{
    INSTANCE;
    public final java.awt.image.BufferedImage FOG_SUN = createSun(44, false, false);
    public final java.awt.image.BufferedImage SUN = createSun(44, false, true);
    public final java.awt.image.BufferedImage BRIGHT_SUN = createSun(44, true, true);
    public final java.awt.image.BufferedImage MOON = createMoon(40);
    public final java.awt.image.BufferedImage RAIN_DROP = createRainDrop(7);
    public final java.awt.image.BufferedImage FLURRY = createFlurry(10);
    public final java.awt.image.BufferedImage SNOW_FLAKE = createSnowFlake(15);
    public final java.awt.image.BufferedImage BIG_BRIGHT_CLOUD = createBigBrightCloud(82);
    public final java.awt.image.BufferedImage BIG_DARK_CLOUD = createBigDarkCloud(82);
    public final java.awt.image.BufferedImage SMALLER_CLOUD = createSmallerCloud(93);
    public final java.awt.image.BufferedImage SMALLER_CLOUD2 = createSmallerCloud2(93);
    public final java.awt.image.BufferedImage SMALL_CLOUD = createSmallCloud(93);
    public final java.awt.image.BufferedImage UNSETTLED_CLOUD = createUnsettledCloud(93);
    public final java.awt.image.BufferedImage FOG = createFog(96);
    public final java.awt.image.BufferedImage FLASH = createFlash(34);
    public final java.awt.image.BufferedImage HAZY = createHazy(96);
    public final java.awt.image.BufferedImage QUESTION_MARK = createQuestionMark(96);

    private java.awt.image.BufferedImage createSun(int size, boolean isBright, boolean hasBeams)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(size, size, java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        java.awt.geom.Point2D CENTER = new java.awt.geom.Point2D.Double(size / 2.0, size / 2.0);

        // Draw sun beams
        if (hasBeams)
        {
            final java.awt.geom.GeneralPath BEAM = new java.awt.geom.GeneralPath();
            BEAM.moveTo(CENTER.getX(), 0);
            BEAM.lineTo(33, CENTER.getY());
            BEAM.lineTo(CENTER.getX(), size);
            BEAM.lineTo(11, CENTER.getY());
            BEAM.closePath();

            final float[] BEAM_FRACTIONS =
            {
                0.0f,
                1.0f
            };

            final java.awt.Color[] BEAM_COLORS =
            {
                new java.awt.Color(0xFF6600),
                new java.awt.Color(1.0f, 1.0f, 0.0f, 0.5f)
            };

            final java.awt.RadialGradientPaint BEAM_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (size / 2.0f), BEAM_FRACTIONS, BEAM_COLORS);

            g2.setPaint(BEAM_GRADIENT);

            final java.awt.geom.AffineTransform OLD_TRANSFORM = g2.getTransform();

            for (int alpha = 0; alpha < 180; alpha += 20)
            {
                g2.rotate(Math.toRadians(alpha), CENTER.getX(), CENTER.getY());
                g2.fill(BEAM);
                g2.setTransform(OLD_TRANSFORM);
            }

            g2.setTransform(OLD_TRANSFORM);

        }

        // Draw back glow effect
        java.awt.Shape BACK_GLOW = new java.awt.geom.Ellipse2D.Double(0, 0, size, size);

        final float[] BACK_GLOW_FRACTIONS =
        {
            0.0f,
            0.5f,
            1.0f
        };

        final java.awt.Color[] BACK_GLOW_COLORS =
        {
            new java.awt.Color(0xFFFF00),
            new java.awt.Color(0xFF9900),
            new java.awt.Color(255, 153, 0, 10)
        };

        final java.awt.RadialGradientPaint BACK_GLOW_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (size / 2.0f), BACK_GLOW_FRACTIONS, BACK_GLOW_COLORS);

        g2.setPaint(BACK_GLOW_GRADIENT);
        g2.fill(BACK_GLOW);

        // Draw main body of sun
        final java.awt.Shape MAIN_BODY = new java.awt.geom.Ellipse2D.Double(size * 0.159090, size * 0.159090, size * 0.681818, size * 0.681818);

        final java.awt.geom.Point2D MAIN_BODY_START = new java.awt.geom.Point2D.Double(0, MAIN_BODY.getBounds2D().getMinY());
        final java.awt.geom.Point2D MAIN_BODY_STOP = new java.awt.geom.Point2D.Double(0, MAIN_BODY.getBounds2D().getMaxY());

        final float[] MAIN_BODY_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] MAIN_BODY_COLORS =
        {
            new java.awt.Color(0xFF6600),
            new java.awt.Color(0xFFFF00)
        };

        final java.awt.LinearGradientPaint MAIN_BODY_GRADIENT = new java.awt.LinearGradientPaint(MAIN_BODY_START, MAIN_BODY_STOP, MAIN_BODY_FRACTIONS, MAIN_BODY_COLORS);

        g2.setPaint(MAIN_BODY_GRADIENT);
        g2.fill(MAIN_BODY);

        // Draw main body frame
        final java.awt.Color MAIN_BODY_FRAME_COLOR = new java.awt.Color(0xFF9900);
        g2.setColor(MAIN_BODY_FRAME_COLOR);
        g2.draw(MAIN_BODY);

        // Draw main body inner shadow
        final float[] MAIN_BODY_INNER_SHADOW_FRACTIONS =
        {
            0.0f,
            0.75f,
            1.0f
        };

        final java.awt.Color[] MAIN_BODY_INNER_SHADOW_COLORS =
        {
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f),
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f),
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.3f)
        };

        final java.awt.RadialGradientPaint MAIN_BODY_INNER_SHADOW_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (float) (MAIN_BODY.getBounds2D().getWidth() / 2.0), MAIN_BODY_INNER_SHADOW_FRACTIONS, MAIN_BODY_INNER_SHADOW_COLORS);

        g2.setPaint(MAIN_BODY_INNER_SHADOW_GRADIENT);
        g2.fill(MAIN_BODY);

        // Draw top light effect
        final java.awt.Shape LIGHT_EFFECT = new java.awt.geom.Ellipse2D.Double(size * 0.25, size * 0.204545, size * 0.5, size * 0.272727);

        final java.awt.geom.Point2D LIGHT_EFFECT_START = new java.awt.geom.Point2D.Double(0, LIGHT_EFFECT.getBounds2D().getMinY());
        final java.awt.geom.Point2D LIGHT_EFFECT_STOP = new java.awt.geom.Point2D.Double(0, LIGHT_EFFECT.getBounds2D().getMaxY());

        final float[] LIGHT_EFFECT_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] LIGHT_EFFECT_COLORS =
        {
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.4f),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        final java.awt.LinearGradientPaint LIGHT_EFFECT_GRADIENT = new java.awt.LinearGradientPaint(LIGHT_EFFECT_START, LIGHT_EFFECT_STOP, LIGHT_EFFECT_FRACTIONS, LIGHT_EFFECT_COLORS);

        g2.setPaint(LIGHT_EFFECT_GRADIENT);
        g2.fill(LIGHT_EFFECT);

        // Draw front glow
        if (isBright)
        {
            final java.awt.Shape FRONT_GLOW = new java.awt.geom.Ellipse2D.Double(0, 0, size, size);

            final float[] FRONT_GLOW_FRACTIONS =
            {
                0.0f,
                1.0f
            };

            final java.awt.Color[] FRONT_GLOW_COLORS =
            {
                new java.awt.Color(1.0f, 1.0f, 0.0f, 1.0f),
                new java.awt.Color(1.0f, 1.0f, 0.0f, 0.0f)
            };

            final java.awt.RadialGradientPaint FRONT_GLOW_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (size / 2f), FRONT_GLOW_FRACTIONS, FRONT_GLOW_COLORS);

            g2.setPaint(FRONT_GLOW_GRADIENT);
            g2.fill(FRONT_GLOW);
        }

        g2.dispose();

        return IMAGE;

    }

    private java.awt.image.BufferedImage createMoon(int size)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(size, size, java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        java.awt.geom.Point2D CENTER = new java.awt.geom.Point2D.Double(size / 2.0, size / 2.0);

        // Draw back glow effect
        java.awt.Shape BACK_GLOW = new java.awt.geom.Ellipse2D.Double(0, 0, size, size);

        final float[] BACK_GLOW_FRACTIONS =
        {
            0.0f,
            0.5f,
            1.0f
        };

        final java.awt.Color[] BACK_GLOW_COLORS =
        {
            new java.awt.Color(0x40565F),
            new java.awt.Color(0x40565F),
            new java.awt.Color(64, 86, 95, 10)
        };

        final java.awt.RadialGradientPaint BACK_GLOW_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (size / 2.0f), BACK_GLOW_FRACTIONS, BACK_GLOW_COLORS);

        g2.setPaint(BACK_GLOW_GRADIENT);
        g2.fill(BACK_GLOW);

        // Draw main body of moon
        final java.awt.Shape MAIN_BODY = new java.awt.geom.Ellipse2D.Double(size * 0.125, size * 0.125, size * 0.75, size * 0.75);

        final java.awt.geom.Point2D MAIN_BODY_START = new java.awt.geom.Point2D.Double(0, MAIN_BODY.getBounds2D().getMinY());
        final java.awt.geom.Point2D MAIN_BODY_STOP = new java.awt.geom.Point2D.Double(0, MAIN_BODY.getBounds2D().getMaxY());

        final float[] MAIN_BODY_FRACTIONS =
        {
            0.0f,
            0.5f,
            1.0f
        };

        final java.awt.Color[] MAIN_BODY_COLORS =
        {
            new java.awt.Color(0xB3C1C1),
            new java.awt.Color(0x6E8593),
            new java.awt.Color(0x40565F)
        };

        final java.awt.LinearGradientPaint MAIN_BODY_GRADIENT = new java.awt.LinearGradientPaint(MAIN_BODY_START, MAIN_BODY_STOP, MAIN_BODY_FRACTIONS, MAIN_BODY_COLORS);

        g2.setPaint(MAIN_BODY_GRADIENT);
        g2.fill(MAIN_BODY);

        // Draw main body inner shadow
        final float[] MAIN_BODY_INNER_SHADOW_FRACTIONS =
        {
            0.0f,
            0.75f,
            1.0f
        };

        final java.awt.Color[] MAIN_BODY_INNER_SHADOW_COLORS =
        {
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f),
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f),
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.3f)
        };

        final java.awt.RadialGradientPaint MAIN_BODY_INNER_SHADOW_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (float) (MAIN_BODY.getBounds2D().getWidth() / 2.0), MAIN_BODY_INNER_SHADOW_FRACTIONS, MAIN_BODY_INNER_SHADOW_COLORS);

        g2.setPaint(MAIN_BODY_INNER_SHADOW_GRADIENT);
        g2.fill(MAIN_BODY);

        // Draw crater 1
        java.awt.Shape CRATER1_BACK = new java.awt.geom.Ellipse2D.Double(size * 0.425, size * 0.25, size * 0.15, size * 0.15);

        final java.awt.geom.Point2D CRATER1_BACK_START = new java.awt.geom.Point2D.Double(0, CRATER1_BACK.getBounds2D().getMinY());
        final java.awt.geom.Point2D CRATER1_BACK_STOP = new java.awt.geom.Point2D.Double(0, CRATER1_BACK.getBounds2D().getMaxY());

        final float[] CRATER1_BACK_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CRATER1_BACK_COLORS =
        {
            new java.awt.Color(0x26455F),
            new java.awt.Color(0x82ACC8)
        };

        final java.awt.LinearGradientPaint CRATER1_BACK_GRADIENT = new java.awt.LinearGradientPaint(CRATER1_BACK_START, CRATER1_BACK_STOP, CRATER1_BACK_FRACTIONS, CRATER1_BACK_COLORS);

        g2.setPaint(CRATER1_BACK_GRADIENT);
        g2.fill(CRATER1_BACK);

        java.awt.Shape CRATER1_FRONT = new java.awt.geom.Ellipse2D.Double(size * 0.45, size * 0.275, size * 0.1, size * 0.1);

        g2.setColor(new java.awt.Color(0x6B8491));
        g2.fill(CRATER1_FRONT);

        // Draw crater 2
        java.awt.Shape CRATER2_BACK = new java.awt.geom.Ellipse2D.Double(size * 0.225, size * 0.5, size * 0.15, size * 0.15);

        final java.awt.geom.Point2D CRATER2_BACK_START = new java.awt.geom.Point2D.Double(0, CRATER2_BACK.getBounds2D().getMinY());
        final java.awt.geom.Point2D CRATER2_BACK_STOP = new java.awt.geom.Point2D.Double(0, CRATER2_BACK.getBounds2D().getMaxY());

        final float[] CRATER2_BACK_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CRATER2_BACK_COLORS =
        {
            new java.awt.Color(0x48646C),
            new java.awt.Color(0x6388A2)
        };

        final java.awt.LinearGradientPaint CRATER2_BACK_GRADIENT = new java.awt.LinearGradientPaint(CRATER2_BACK_START, CRATER2_BACK_STOP, CRATER2_BACK_FRACTIONS, CRATER2_BACK_COLORS);

        g2.setPaint(CRATER2_BACK_GRADIENT);
        g2.fill(CRATER2_BACK);

        java.awt.Shape CRATER2_FRONT = new java.awt.geom.Ellipse2D.Double(size * 0.25, size * 0.525, size * 0.1, size * 0.1);

        g2.setColor(new java.awt.Color(0x4A6770));
        g2.fill(CRATER2_FRONT);


        // Draw crater 3
        java.awt.Shape CRATER3_BACK = new java.awt.geom.Ellipse2D.Double(size * 0.55, size * 0.6, size * 0.15, size * 0.15);

        final java.awt.geom.Point2D CRATER3_BACK_START = new java.awt.geom.Point2D.Double(0, CRATER3_BACK.getBounds2D().getMinY());
        final java.awt.geom.Point2D CRATER3_BACK_STOP = new java.awt.geom.Point2D.Double(0, CRATER3_BACK.getBounds2D().getMaxY());

        final float[] CRATER3_BACK_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CRATER3_BACK_COLORS =
        {
            new java.awt.Color(0x49656D),
            new java.awt.Color(0x6A8291)
        };

        final java.awt.LinearGradientPaint CRATER3_BACK_GRADIENT = new java.awt.LinearGradientPaint(CRATER3_BACK_START, CRATER3_BACK_STOP, CRATER3_BACK_FRACTIONS, CRATER3_BACK_COLORS);

        g2.setPaint(CRATER3_BACK_GRADIENT);
        g2.fill(CRATER3_BACK);

        java.awt.Shape CRATER3_FRONT = new java.awt.geom.Ellipse2D.Double(size * 0.575, size * 0.625, size * 0.1, size * 0.1);

        g2.setColor(new java.awt.Color(0x48656D));
        g2.fill(CRATER3_FRONT);

        // Draw top light effect
        final java.awt.Shape LIGHT_EFFECT = new java.awt.geom.Ellipse2D.Double(size * 0.225, size * 0.175, size * 0.55, size * 0.3);

        final java.awt.geom.Point2D LIGHT_EFFECT_START = new java.awt.geom.Point2D.Double(0, LIGHT_EFFECT.getBounds2D().getMinY());
        final java.awt.geom.Point2D LIGHT_EFFECT_STOP = new java.awt.geom.Point2D.Double(0, LIGHT_EFFECT.getBounds2D().getMaxY());

        final float[] LIGHT_EFFECT_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] LIGHT_EFFECT_COLORS =
        {
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.3f),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        final java.awt.LinearGradientPaint LIGHT_EFFECT_GRADIENT = new java.awt.LinearGradientPaint(LIGHT_EFFECT_START, LIGHT_EFFECT_STOP, LIGHT_EFFECT_FRACTIONS, LIGHT_EFFECT_COLORS);

        g2.setPaint(LIGHT_EFFECT_GRADIENT);
        g2.fill(LIGHT_EFFECT);

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createRainDrop(int size)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(size, size, java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        // Draw raindrop
        java.awt.geom.GeneralPath DROP = new java.awt.geom.GeneralPath();
        DROP.moveTo(size * 0.85714285716, 0);
        DROP.lineTo(size * 0.85714285716, size * 0.2857142857);
        DROP.lineTo(size * 0.85714285716, size * 0.5714285714);
        DROP.lineTo(size * 0.85714285716, size * 0.85714285716);
        DROP.lineTo(size * 0.4285714286, size);
        DROP.lineTo(size * 0.1428571429, size * 0.85714285716);
        DROP.lineTo(size * 0.1428571429, size * 0.5714285714);
        DROP.lineTo(size * 0.4285714286, size * 0.2857142857);
        DROP.lineTo(size * 0.5714285714, size * 0.1428571429);
        DROP.closePath();

        final java.awt.geom.Point2D CENTER = new java.awt.geom.Point2D.Double(size * 0.4285714286, size * 0.7142857143);

        final float[] DROP_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] DROP_COLORS =
        {
            new java.awt.Color(0xC5E8F2),
            new java.awt.Color(0x75C7E9)
        };

        final java.awt.RadialGradientPaint DROP_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (size * 0.7142857143f), DROP_FRACTIONS, DROP_COLORS);

        g2.setPaint(DROP_GRADIENT);
        g2.fill(DROP);

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createFlurry(int size)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(size, size, java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final java.awt.geom.Point2D CENTER = new java.awt.geom.Point2D.Double(size / 2.0, size / 2.0);

        // Draw flurry flake
        java.awt.geom.GeneralPath FLAKE = new java.awt.geom.GeneralPath();
        FLAKE.moveTo(size * 0.5, 0);
        FLAKE.lineTo(size * 0.6, size * 0.3);
        FLAKE.lineTo(size * 0.8, size * 0.1);
        FLAKE.lineTo(size * 0.7, size * 0.4);
        FLAKE.lineTo(size, size * 0.5);
        FLAKE.lineTo(size * 0.7, size * 0.6);
        FLAKE.lineTo(size * 0.8, size * 0.9);
        FLAKE.lineTo(size * 0.6, size * 0.7);
        FLAKE.lineTo(size * 0.5, size);
        FLAKE.lineTo(size * 0.4, size * 0.7);
        FLAKE.lineTo(size * 0.2, size * 0.9);
        FLAKE.lineTo(size * 0.3, size * 0.6);
        FLAKE.lineTo(0, size * 0.5);
        FLAKE.lineTo(size * 0.3, size * 0.4);
        FLAKE.lineTo(size * 0.2, size * 0.1);
        FLAKE.lineTo(size * 0.4, size * 0.3);
        FLAKE.closePath();

        final float[] SNOW_FLAKE_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] SNOW_FLAKE_COLORS =
        {
            new java.awt.Color(0xCCCCCC),
            new java.awt.Color(0xFFFFFF)
        };

        final java.awt.RadialGradientPaint SNOW_FLAKE_GRADIENT = new java.awt.RadialGradientPaint(CENTER, (size * 0.5f), SNOW_FLAKE_FRACTIONS, SNOW_FLAKE_COLORS);

        g2.setPaint(SNOW_FLAKE_GRADIENT);
        g2.fill(FLAKE);

        //g2.setStroke(new java.awt.BasicStroke(0.25f, java.awt.BasicStroke.CAP_ROUND, java.awt.BasicStroke.JOIN_ROUND));
        //g2.setColor(new java.awt.Color(1.0f, 1.0f, 1.0f, 0.8f));
        //g2.draw(FLAKE);

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createSnowFlake(int size)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(size, size, java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final java.awt.geom.Point2D CENTER = new java.awt.geom.Point2D.Double(size / 2.0, size / 2.0);

        // Draw snowflake
        g2.setStroke(new java.awt.BasicStroke(0.25f, java.awt.BasicStroke.CAP_ROUND, java.awt.BasicStroke.JOIN_ROUND));
        g2.setColor(new java.awt.Color(1.0f, 1.0f, 1.0f, 0.8f));

        for (int angle = 0; angle < 360; angle += 45)
        {
            g2.rotate(Math.toRadians(angle), CENTER.getX(), CENTER.getY());
            g2.draw(new java.awt.geom.Line2D.Double(CENTER.getX(), 0, CENTER.getX(), size));
            g2.draw(new java.awt.geom.Line2D.Double(CENTER.getX(), size * 0.2666666667, CENTER.getX() - size * 0.1333333333, size * 0.0666666667));
            g2.draw(new java.awt.geom.Line2D.Double(CENTER.getX(), size * 0.2666666667, CENTER.getX() + size * 0.1333333333, size * 0.0666666667));
            g2.draw(new java.awt.geom.Line2D.Double(CENTER.getX(), size - size * 0.2666666667, CENTER.getX() - size * 0.1333333333, size - size * 0.0666666667));
            g2.draw(new java.awt.geom.Line2D.Double(CENTER.getX(), size - size * 0.2666666667, CENTER.getX() + size * 0.1333333333, size - size * 0.0666666667));
            g2.rotate(Math.toRadians(-angle), CENTER.getX(), CENTER.getY());
        }

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createBigBrightCloud(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.4705882353), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] CLOUD_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CLOUD_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(0xFFFFFF)
        };

        final java.awt.Color[] CLOUD_FRAME_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloudEllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(20);

        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.402439024390244, width * 0.024390243902439, width * 0.219512195121951, width * 0.170731707317073));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.5, 0, width * 0.231707317073171, width * 0.170731707317073));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.609756097560976, width * 0.0731707317073171, width * 0.292682926829268, width * 0.219512195121951));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.780487804878049, width * 0.195121951219512, width * 0.219512195121951, width * 0.146341463414634));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.585365853658537, width * 0.24390243902439, width * 0.280487804878049, width * 0.146341463414634));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.365853658536585, width * 0.109756097560976, width * 0.121951219512195, width * 0.0975609756097561));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.402439024390244, width * 0.146341463414634, width * 0.304878048780488, width * 0.24390243902439));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.475609756097561, width * 0.0853658536585366, width * 0.219512195121951, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.51219512195122, width * 0.134146341463415, width * 0.365853658536585, width * 0.207317073170732));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.378048780487805, width * 0.134146341463415, width * 0.25609756097561, width * 0.170731707317073));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.231707317073171, width * 0.121951219512195, width * 0.158536585365854, width * 0.0853658536585366));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.317073170731707, width * 0.170731707317073, width * 0.207317073170732, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.365853658536585, width * 0.24390243902439, width * 0.268292682926829, width * 0.134146341463415));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.134146341463415, width * 0.134146341463415, width * 0.158536585365854, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0853658536585366, width * 0.182926829268293, width * 0.317073170731707, width * 0.146341463414634));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.195121951219512, width * 0.280487804878049, width * 0.353658536585366, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.121951219512195, width * 0.280487804878049, width * 0.170731707317073, width * 0.0731707317073171));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.109756097560976, width * 0.207317073170732, width * 0.195121951219512, width * 0.109756097560976));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(0, width * 0.25609756097561, width * 0.280487804878049, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.121951219512195, width * 0.231707317073171, width * 0.304878048780488, width * 0.158536585365854));


        java.awt.geom.Point2D start;
        java.awt.geom.Point2D stop;
        java.awt.LinearGradientPaint cloudGradient;
        java.awt.LinearGradientPaint cloudFrameGradient;

        // Draw big cloud
        for (java.awt.geom.Ellipse2D cloud : cloudEllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createBigDarkCloud(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.4705882353), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] CLOUD_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CLOUD_COLORS =
        {
            new java.awt.Color(0xAAACAC),
            new java.awt.Color(0xD8E0E8)
        };

        final java.awt.Color CLOUD_FRAME_COLOR = new java.awt.Color(0xC6C6C3);

        final java.awt.Color[] CLOUD_FRAME_COLORS =
        {
            new java.awt.Color(0xC6C6C3),
            new java.awt.Color(216, 224, 232, 0)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloudEllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(20);

        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.402439024390244, width * 0.024390243902439, width * 0.219512195121951, width * 0.170731707317073));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.5, 0, width * 0.231707317073171, width * 0.170731707317073));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.609756097560976, width * 0.0731707317073171, width * 0.292682926829268, width * 0.219512195121951));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.780487804878049, width * 0.195121951219512, width * 0.219512195121951, width * 0.146341463414634));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.585365853658537, width * 0.24390243902439, width * 0.280487804878049, width * 0.146341463414634));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.365853658536585, width * 0.109756097560976, width * 0.121951219512195, width * 0.0975609756097561));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.402439024390244, width * 0.146341463414634, width * 0.304878048780488, width * 0.24390243902439));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.475609756097561, width * 0.0853658536585366, width * 0.219512195121951, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.51219512195122, width * 0.134146341463415, width * 0.365853658536585, width * 0.207317073170732));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.378048780487805, width * 0.134146341463415, width * 0.25609756097561, width * 0.170731707317073));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.231707317073171, width * 0.121951219512195, width * 0.158536585365854, width * 0.0853658536585366));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.317073170731707, width * 0.170731707317073, width * 0.207317073170732, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.365853658536585, width * 0.24390243902439, width * 0.268292682926829, width * 0.134146341463415));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.134146341463415, width * 0.134146341463415, width * 0.158536585365854, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0853658536585366, width * 0.182926829268293, width * 0.317073170731707, width * 0.146341463414634));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.195121951219512, width * 0.280487804878049, width * 0.353658536585366, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.121951219512195, width * 0.280487804878049, width * 0.170731707317073, width * 0.0731707317073171));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.109756097560976, width * 0.207317073170732, width * 0.195121951219512, width * 0.109756097560976));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(0, width * 0.25609756097561, width * 0.280487804878049, width * 0.121951219512195));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.121951219512195, width * 0.231707317073171, width * 0.304878048780488, width * 0.158536585365854));


        java.awt.geom.Point2D start;
        java.awt.geom.Point2D stop;
        java.awt.LinearGradientPaint cloudGradient;
        java.awt.LinearGradientPaint cloudFrameGradient;

        // Draw big cloud
        for (java.awt.geom.Ellipse2D cloud : cloudEllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }

        for (java.awt.geom.Ellipse2D cloud : cloudEllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);
            g2.setColor(CLOUD_FRAME_COLOR);
            g2.draw(cloud);
        }

        // Draw cloud with flash light effect
        final java.awt.geom.Area CLOUD_AREA = new java.awt.geom.Area();

        // Draw big cloud
        for (java.awt.geom.Ellipse2D cloud : cloudEllipseList)
        {
            CLOUD_AREA.add(new java.awt.geom.Area(cloud));
        }

        final java.awt.geom.GeneralPath CLOUD = new java.awt.geom.GeneralPath(CLOUD_AREA);

        final java.awt.geom.Point2D FLASH_LIGHT_START = new java.awt.geom.Point2D.Double(0, CLOUD.getBounds2D().getMinY());
        final java.awt.geom.Point2D FLASH_LIGHT_STOP = new java.awt.geom.Point2D.Double(0, CLOUD.getBounds2D().getMaxY());

        final float[] FLASH_LIGHT_FRACTIONS =
        {
            0.0f,
            0.65f,
            0.85f,
            1.0f
        };

        final java.awt.Color[] FLASH_LIGHT_COLORS =
        {
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.10f),
            new java.awt.Color(0.44705f, 0.23137f, 0.0f, 0.15f),
            new java.awt.Color(0.98431f, 0.73725f, 0.25098f, 0.6f),
            new java.awt.Color(0.98431f, 0.73725f, 0.25098f, 1.0f)
        };

        final java.awt.LinearGradientPaint FLASH_LIGHT_GRADIENT = new java.awt.LinearGradientPaint(FLASH_LIGHT_START, FLASH_LIGHT_STOP, FLASH_LIGHT_FRACTIONS, FLASH_LIGHT_COLORS);

        g2.setPaint(FLASH_LIGHT_GRADIENT);
        g2.fill(CLOUD);


        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createSmallerCloud(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.2580645161), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] CLOUD_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CLOUD_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(0xFFFFFF)
        };

        final java.awt.Color[] CLOUD_FRAME_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloud1EllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(9);

        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.505376344086022, width * 0.0967741935483871, width * 0.150537634408602, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.43010752688172, width * 0.139784946236559, width * 0.193548387096774, width * 0.0967741935483871));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.559139784946237, width * 0.139784946236559, width * 0.21505376344086, width * 0.118279569892473));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.602150537634409, width * 0.021505376344086, width * 0.129032258064516, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.666666666666667, 0, width * 0.150537634408602, width * 0.0967741935483871));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.752688172043011, width * 0.0537634408602151, width * 0.182795698924731, width * 0.129032258064516));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.838709677419355, width * 0.10752688172043, width * 0.161290322580645, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.655913978494624, width * 0.0752688172043011, width * 0.301075268817204, width * 0.161290322580645));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.548387096774194, width * 0.0645161290322581, width * 0.172043010752688, width * 0.0967741935483871));

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloud2EllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(6);

        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0537634408602151, width * 0.043010752688172, width * 0.118279569892473, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0752688172043011, width * 0.010752688172043, width * 0.129032258064516, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.150537634408602, width * 0.032258064516129, width * 0.193548387096774, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.10752688172043, width * 0.0752688172043011, width * 0.193548387096774, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.236559139784946, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));


        java.awt.geom.Point2D start;
        java.awt.geom.Point2D stop;
        java.awt.LinearGradientPaint cloudGradient;
        java.awt.LinearGradientPaint cloudFrameGradient;

        // Draw bigger cloud on right side
        for (java.awt.geom.Ellipse2D cloud : cloud1EllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }

        // Draw small cloud on left side
        for (java.awt.geom.Ellipse2D cloud : cloud2EllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }


        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createSmallerCloud2(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.3010752688), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] CLOUD_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CLOUD_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(0xFFFFFF)
        };

        final java.awt.Color[] CLOUD_FRAME_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloud1EllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(9);

        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.505376344086022, width * 0.0967741935483871, width * 0.150537634408602, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.43010752688172, width * 0.139784946236559, width * 0.193548387096774, width * 0.0967741935483871));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.559139784946237, width * 0.139784946236559, width * 0.21505376344086, width * 0.118279569892473));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.602150537634409, width * 0.021505376344086, width * 0.129032258064516, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.666666666666667, 0, width * 0.150537634408602, width * 0.0967741935483871));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.752688172043011, width * 0.0537634408602151, width * 0.182795698924731, width * 0.129032258064516));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.838709677419355, width * 0.10752688172043, width * 0.161290322580645, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.655913978494624, width * 0.0752688172043011, width * 0.301075268817204, width * 0.161290322580645));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.548387096774194, width * 0.0645161290322581, width * 0.172043010752688, width * 0.0967741935483871));

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloud2EllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(6);

        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0537634408602151, width * 0.043010752688172, width * 0.118279569892473, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0752688172043011, width * 0.010752688172043, width * 0.129032258064516, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.150537634408602, width * 0.032258064516129, width * 0.193548387096774, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.10752688172043, width * 0.0752688172043011, width * 0.193548387096774, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.236559139784946, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));


        java.awt.geom.Point2D start;
        java.awt.geom.Point2D stop;
        java.awt.LinearGradientPaint cloudGradient;
        java.awt.LinearGradientPaint cloudFrameGradient;

        // The same clouds as in createSmallerCloud but with changed locations

        // Draw bigger cloud on left side        
        g2.translate(width * -0.42, width * -0.005);
        for (java.awt.geom.Ellipse2D cloud : cloud1EllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }
        g2.translate(width * 0.42, 0);


        // Draw small cloud on right side
        g2.translate(width * 0.5376344086, 0);
        for (java.awt.geom.Ellipse2D cloud : cloud2EllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }
        g2.translate(width * -0.5376344086, 0);

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createSmallCloud(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.2580645161), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] CLOUD_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CLOUD_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(0xFFFFFF)
        };

        final java.awt.Color[] CLOUD_FRAME_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloudEllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(6);

        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0537634408602151, width * 0.043010752688172, width * 0.118279569892473, width * 0.0645161290322581));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0752688172043011, width * 0.010752688172043, width * 0.129032258064516, width * 0.0645161290322581));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.150537634408602, width * 0.032258064516129, width * 0.193548387096774, width * 0.0645161290322581));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.10752688172043, width * 0.0752688172043011, width * 0.193548387096774, width * 0.0645161290322581));
        cloudEllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.236559139784946, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));


        java.awt.geom.Point2D start;
        java.awt.geom.Point2D stop;
        java.awt.LinearGradientPaint cloudGradient;
        java.awt.LinearGradientPaint cloudFrameGradient;

        // Draw small cloud on left side
        for (java.awt.geom.Ellipse2D cloud : cloudEllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createUnsettledCloud(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.2580645161), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] CLOUD_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] CLOUD_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(0xFFFFFF)
        };

        final java.awt.Color[] CLOUD_FRAME_COLORS =
        {
            new java.awt.Color(0xE5E0D8),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloud1EllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(9);

        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.505376344086022, width * 0.0967741935483871, width * 0.150537634408602, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.43010752688172, width * 0.139784946236559, width * 0.193548387096774, width * 0.0967741935483871));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.559139784946237, width * 0.139784946236559, width * 0.21505376344086, width * 0.118279569892473));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.602150537634409, width * 0.021505376344086, width * 0.129032258064516, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.666666666666667, 0, width * 0.150537634408602, width * 0.0967741935483871));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.752688172043011, width * 0.0537634408602151, width * 0.182795698924731, width * 0.129032258064516));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.838709677419355, width * 0.10752688172043, width * 0.161290322580645, width * 0.0860215053763441));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.655913978494624, width * 0.0752688172043011, width * 0.301075268817204, width * 0.161290322580645));
        cloud1EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.548387096774194, width * 0.0645161290322581, width * 0.172043010752688, width * 0.0967741935483871));

        java.util.ArrayList<java.awt.geom.Ellipse2D> cloud2EllipseList = new java.util.ArrayList<java.awt.geom.Ellipse2D>(6);

        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0537634408602151, width * 0.043010752688172, width * 0.118279569892473, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.0752688172043011, width * 0.010752688172043, width * 0.129032258064516, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.150537634408602, width * 0.032258064516129, width * 0.193548387096774, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.10752688172043, width * 0.0752688172043011, width * 0.193548387096774, width * 0.0645161290322581));
        cloud2EllipseList.add(new java.awt.geom.Ellipse2D.Double(width * 0.236559139784946, width * 0.0645161290322581, width * 0.139784946236559, width * 0.0645161290322581));


        java.awt.geom.Point2D start;
        java.awt.geom.Point2D stop;
        java.awt.LinearGradientPaint cloudGradient;
        java.awt.LinearGradientPaint cloudFrameGradient;

        // Draw bigger cloud on right side
        g2.translate(width * -0.2043010753, width * -0.0322580645);
        for (java.awt.geom.Ellipse2D cloud : cloud1EllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }
        g2.translate(width * 0.2043010753, width * 0.0322580645);

        // Draw small cloud on left side
        for (java.awt.geom.Ellipse2D cloud : cloud2EllipseList)
        {
            start = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMinY());
            stop = new java.awt.geom.Point2D.Double(0, cloud.getBounds2D().getMaxY());
            cloudGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_COLORS);

            g2.setPaint(cloudGradient);
            g2.fill(cloud);

            cloudFrameGradient = new java.awt.LinearGradientPaint(start, stop, CLOUD_FRACTIONS, CLOUD_FRAME_COLORS);
            g2.setPaint(cloudFrameGradient);
            g2.draw(cloud);
        }


        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createFog(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.5), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] FOG_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] FOG_COLORS =
        {
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.2f),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        java.util.ArrayList<java.awt.geom.Ellipse2D> FOG_LOCATION_LIST = new java.util.ArrayList<java.awt.geom.Ellipse2D>(18);

        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.0, 0.0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.6875, 0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.583333333333333, width * 0.114583333333333, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.6875, width * 0.114583333333333, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.65625, width * 0.1875, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.479166666666667, width * 0.177083333333333, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.552083333333333, 0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.395833333333333, 0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.458333333333333, 0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.177083333333333, width * 0.1875, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.395833333333333, width * 0.114583333333333, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.260416666666667, width * 0.1875, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.270833333333333, width * 0.0625, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.21875, 0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.135416666666667, width * 0.0625, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.09375, width * 0.177083333333333, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(0, width * 0.1875, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(0, 0, width * 0.3125, width * 0.3125));
        FOG_LOCATION_LIST.add(new java.awt.geom.Ellipse2D.Double(width * 0.09375, width * -0.0520833333333333, width * 0.3125, width * 0.3125));

        final float RADIUS = width * 0.15625f;
        java.awt.RadialGradientPaint fogGradient;

        // Draw big cloud
        for (java.awt.geom.Ellipse2D fog : FOG_LOCATION_LIST)
        {
            fogGradient = new java.awt.RadialGradientPaint(new java.awt.geom.Point2D.Double(fog.getCenterX(), fog.getCenterY()), RADIUS, FOG_FRACTIONS, FOG_COLORS);
            g2.setPaint(fogGradient);
            g2.fill(fog);
        }

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createFlash(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.4705882353), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        // Draw flashes
        final float[] FLASH_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] FLASH_COLORS =
        {
            new java.awt.Color(0xFB8134),
            new java.awt.Color(0xFBD845)
        };

        // Draw flash1
        java.awt.geom.GeneralPath FLASH1 = new java.awt.geom.GeneralPath();
        FLASH1.moveTo(width * 0.1176470588, width * 0.0294117647);
        FLASH1.lineTo(width * 0.2941176471, width * 0.0294117647);
        FLASH1.lineTo(width * 0.2058823529, width * 0.1470588235);
        FLASH1.lineTo(width * 0.3235294118, width * 0.1470588235);
        FLASH1.lineTo(width * 0.0294117647, width * 0.4705882353);
        FLASH1.lineTo(width * 0.1470588235, width * 0.2058823529);
        FLASH1.lineTo(width * 0.0588235294, width * 0.2058823529);
        FLASH1.closePath();

        FLASH1.closePath();

        final java.awt.geom.Point2D FLASH1_START = new java.awt.geom.Point2D.Double(0, FLASH1.getBounds2D().getMinY());
        final java.awt.geom.Point2D FLASH1_STOP = new java.awt.geom.Point2D.Double(0, FLASH1.getBounds2D().getMaxY());

        final java.awt.LinearGradientPaint FLASH1_GRADIENT = new java.awt.LinearGradientPaint(FLASH1_START, FLASH1_STOP, FLASH_FRACTIONS, FLASH_COLORS);

        g2.setPaint(FLASH1_GRADIENT);
        g2.fill(FLASH1);

        // Draw flash2
        java.awt.geom.GeneralPath FLASH2 = new java.awt.geom.GeneralPath();
        FLASH2.moveTo(width * 0.8823529412, 0);
        FLASH2.lineTo(width, 0);
        FLASH2.lineTo(width * 0.9411764706, width * 0.0882352941);
        FLASH2.lineTo(width, width * 0.0882352941);
        FLASH2.lineTo(width * 0.7941176471, width * 0.2941176471);
        FLASH2.lineTo(width * 0.8823529412, width * 0.1470588235);
        FLASH2.lineTo(width * 0.8235294118, width * 0.1470588235);
        FLASH2.closePath();

        FLASH2.closePath();

        final java.awt.geom.Point2D FLASH2_START = new java.awt.geom.Point2D.Double(0, FLASH2.getBounds2D().getMinY());
        final java.awt.geom.Point2D FLASH2_STOP = new java.awt.geom.Point2D.Double(0, FLASH2.getBounds2D().getMaxY());

        final java.awt.LinearGradientPaint FLASH2_GRADIENT = new java.awt.LinearGradientPaint(FLASH2_START, FLASH2_STOP, FLASH_FRACTIONS, FLASH_COLORS);

        g2.setPaint(FLASH2_GRADIENT);
        g2.fill(FLASH2);

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createHazy(int width)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(width, (int) (width * 0.5), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final float[] HAZY_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] HAZY_COLORS =
        {
            new java.awt.Color(0.8f, 0.8f, 0.8f, 0.4f),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.1f)
        };

        final java.awt.geom.Point2D GRADIENT_CENTER = new java.awt.geom.Point2D.Double(width * 0.28125, width * 0.2395833333);
        final float GRADIENT_RADIUS = width * 0.6770833333f;
        final java.awt.RadialGradientPaint HAZY_GRADIENT = new java.awt.RadialGradientPaint(GRADIENT_CENTER, GRADIENT_RADIUS, HAZY_FRACTIONS, HAZY_COLORS);

        g2.setPaint(HAZY_GRADIENT);
        g2.fill(new java.awt.geom.Rectangle2D.Double(0, 0, width, width * 0.5));

        g2.dispose();

        return IMAGE;
    }

    private java.awt.image.BufferedImage createQuestionMark(int width)
    {
       java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage((int) (width * 0.1875), (int) (width * 0.1875), java.awt.Transparency.TRANSLUCENT);

        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        final java.awt.geom.Ellipse2D MAIN_FORM = new java.awt.geom.Ellipse2D.Double(0, 0, IMAGE.getWidth(), IMAGE.getHeight());

        final float[] BACKGROUND_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] BACKGROUND_COLORS =
        {
            new java.awt.Color(0x9966FF),
            new java.awt.Color(0x6600CC)
        };

        final java.awt.geom.Point2D BACKGROUND_START = new java.awt.geom.Point2D.Double(0, MAIN_FORM.getMinY());
        final java.awt.geom.Point2D BACKGROUND_STOP = new java.awt.geom.Point2D.Double(0, MAIN_FORM.getMaxY());

        final java.awt.LinearGradientPaint BACKGROUND_GRADIENT = new java.awt.LinearGradientPaint(BACKGROUND_START, BACKGROUND_STOP, BACKGROUND_FRACTIONS, BACKGROUND_COLORS);

        g2.setPaint(BACKGROUND_GRADIENT);
        g2.fill(MAIN_FORM);

        final float[] INNER_SHADOW_FRACTIONS =
        {
            0.0f,
            0.8f,
            1.0f
        };

        final java.awt.Color[] INNER_SHADOW_COLORS =
        {
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f),
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f),
            new java.awt.Color(0.0f, 0.0f, 0.0f, 0.5f)
        };

        final java.awt.geom.Point2D INNER_SHADOW_CENTER = new java.awt.geom.Point2D.Double(MAIN_FORM.getCenterX(), MAIN_FORM.getCenterY());
        final float INNER_SHADOW_RADIUS = (float) (MAIN_FORM.getWidth() / 2.0);

        final java.awt.RadialGradientPaint INNER_SHADOW_GRADIENT = new java.awt.RadialGradientPaint(INNER_SHADOW_CENTER, INNER_SHADOW_RADIUS, INNER_SHADOW_FRACTIONS, INNER_SHADOW_COLORS);

        g2.setPaint(INNER_SHADOW_GRADIENT);
        g2.fill(MAIN_FORM);

        g2.setColor(java.awt.Color.WHITE);
        g2.setFont(new java.awt.Font("Arial", 1, (int) (width * 0.1666666667)));

        g2.drawString("?", width * 0.04f, width *0.155f);

        final java.awt.geom.Ellipse2D LIGHT = new java.awt.geom.Ellipse2D.Double(width * 0.03125, width * 0.0104166667, width * 0.125, width * 0.09375);

        final float[] LIGHT_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final java.awt.Color[] LIGHT_COLORS =
        {
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.4f),
            new java.awt.Color(1.0f, 1.0f, 1.0f, 0.05f),
        };

        final java.awt.geom.Point2D LIGHT_START = new java.awt.geom.Point2D.Double(0, LIGHT.getMinY());
        final java.awt.geom.Point2D LIGHT_STOP = new java.awt.geom.Point2D.Double(0, LIGHT.getMaxY());

        final java.awt.LinearGradientPaint LIGHT_GRADIENT = new java.awt.LinearGradientPaint(LIGHT_START, LIGHT_STOP, LIGHT_FRACTIONS, LIGHT_COLORS);

        g2.setPaint(LIGHT_GRADIENT);
        g2.fill(LIGHT);
        
        g2.dispose();

        return IMAGE;
    }
}

