/**
 * ItemClickEvent.java
 * 10 Oct 2011 Copyright Cheng Wei and Robert Taylor
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
package robobinding.presentationmodel;

import android.view.View;
import android.widget.AdapterView;

/**
 * @since 1.0
 * @author Cheng Wei
 * @author Robert Taylor
 *
 */
public class ItemClickEvent
{
	private AdapterView<?> parent;
	private View view;
	private int position;
	private long id;
	
	public ItemClickEvent(AdapterView<?> parent, View view, int position, long id)
	{
		this.parent = parent;
		this.view = view;
		this.position = position;
		this.id = id;
	}

	public int getPosition()
	{
		return position;
	}

	public long getId()
	{
		return id;
	}

	public AdapterView<?> getParent()
	{
		return parent;
	}

	public View getView()
	{
		return view;
	}
}
