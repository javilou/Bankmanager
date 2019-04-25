package com.imatia.jee.bankmanager.server.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imatia.jee.bankmanager.common.base.constants.ApplicationConstants;
import com.imatia.jee.bankmanager.common.base.constants.entities.Setting;
import com.imatia.jee.bankmanager.server.dao.setup.OCSettingsDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

/**
 * The Class SettingsHelper.
 */
@Component
public class SettingsHelper {

	/** The settings dao. */
	@Autowired
	private OCSettingsDao settingsDao;

	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	/**
	 * Instantiates a new settings helper.
	 */
	public SettingsHelper() {

		super();
	}

	/**
	 * Gets the string.
	 *
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value
	 * @return the string
	 */
	public String getString(String key, String defaultValue) {

		Map<String, Object> filter = new HashMap<>();

		filter.put(Setting.SETTING_KEY, key);

		EntityResult res = this.settingsDao.query(filter, Arrays.asList(new String[] { Setting.SETTING_VALUE }), (List<?>) null, (String) null);

		if (res.calculateRecordNumber() == 1) {

			String value = (String) res.getRecordValues(0).get(Setting.SETTING_VALUE);

			if (value == null) {

				return defaultValue;
			}

			return value;
		}

		return defaultValue;
	}

	/**
	 * Gets the integer.
	 *
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value
	 * @return the integer
	 */
	public Integer getInteger(String key, Integer defaultValue) {

		String sValue = this.getString(key, null);

		if (sValue == null) {

			return defaultValue;
		}

		return Integer.valueOf(sValue);
	}

	public String getSettingValue(String settingKey) {

		Map<String, String> queryKeys = new Hashtable<>();
		List<String> queryValues = new ArrayList<>();

		queryKeys.put(Setting.SETTING_KEY, settingKey);
		queryValues.add(Setting.SETTING_VALUE);

		EntityResult queryResult = this.daoHelper.query(this.settingsDao, queryKeys, queryValues);

		if (!queryResult.isEmpty()) {

			return (String) queryResult.getRecordValues(ApplicationConstants.ZERO).get(Setting.SETTING_VALUE);
		}

		return null;
	}
}
