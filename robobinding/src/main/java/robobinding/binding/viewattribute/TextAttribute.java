/**
 * Copyright 2011 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package robobinding.binding.viewattribute;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import robobinding.binding.BindingType;
import robobinding.value.ValueModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 *
 */
public class TextAttribute extends AbstractPropertyViewAttribute<CharSequence>
{
	private final TextView textView;
	
	public TextAttribute(final TextView textView)
	{
		this.textView = textView;
	}

	@Override
	protected void bindOnto(final ValueModel<CharSequence> valueModel, BindingType bindingType)
	{
		textView.setText(valueModel.getValue());
		
		observeChangesOnTheValueModel(valueModel);
		
		if (bindingType == BindingType.TWO_WAY)
			observeChangesOnTheTextView(valueModel);
	}

	private void observeChangesOnTheValueModel(final ValueModel<CharSequence> valueModel)
	{
		valueModel.addValueChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				textView.setText(valueModel.getValue());
			}
		});
	}

	private void observeChangesOnTheTextView(final ValueModel<CharSequence> valueModel)
	{
		textView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				valueModel.setValue(s);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
			}
			
			@Override
			public void afterTextChanged(Editable s)
			{
			}
		});
	}

}
