/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.hiwepy.validation.internal.constraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.hiwepy.validation.constraints.IdCard;
import com.github.hiwepy.validation.utils.IDCardUtils;
import com.github.hiwepy.validation.utils.IdcardUtils2;

public class IdCardValidator implements ConstraintValidator<IdCard, String> {

	@Override
	public void initialize(IdCard annotation) {
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		return IDCardUtils.isIDCard(input) || IdcardUtils2.validateCard(input) || IdcardUtils2.validateHKCard(input)
				|| IdcardUtils2.validateTWCard(input);
	}

}
