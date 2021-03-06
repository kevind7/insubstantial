/*
 * Copyright (c) 2005-2010 Substance Kirill Grouchnikov. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of Substance Kirill Grouchnikov nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.pushingpixels.substance.internal.fonts;

import java.awt.Font;

import javax.swing.UIDefaults;

import org.pushingpixels.substance.api.fonts.FontPolicy;
import org.pushingpixels.substance.api.fonts.FontSet;

/**
 * The default font policy for Mac desktops.
 * 
 * @author Kirill Grouchnikov
 */
public class DefaultMacFontPolicy implements FontPolicy {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pushingpixels.substance.fonts.FontPolicy#getFontSet(java.lang.String,
	 * javax.swing.UIDefaults)
	 */
	@Override
    public FontSet getFontSet(String lafName, UIDefaults table) {
		Font controlFont = new Font("Lucida Grande", Font.PLAIN, 13);
		Font menuFont = table == null ? new Font("Lucida Grande", Font.PLAIN,
				14) : table.getFont("Menu.font");
		Font titleFont = menuFont;
		Font messageFont = table == null ? controlFont : table
				.getFont("OptionPane.font");
		Font smallFont = table == null ? controlFont.deriveFont(controlFont
				.getSize2D() - 2f) : table.getFont("ToolTip.font");
		Font windowTitleFont = table == null ? titleFont : table
				.getFont("InternalFrame.titleFont");
		return FontSets.createDefaultFontSet(controlFont, menuFont, titleFont,
				messageFont, smallFont, windowTitleFont);
	}
}
