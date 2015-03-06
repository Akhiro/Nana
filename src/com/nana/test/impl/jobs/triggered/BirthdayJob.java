package com.nana.test.impl.jobs.triggered;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

import com.nana.test.struct.common.Birthday;
import com.nana.test.struct.jobs.Job;

public class BirthdayJob extends Job {
	private List<Birthday> _list;

	public BirthdayJob() {
		super();
	}

	public @Nullable List<Birthday> getList() {  return _list;}
	public void setList(@Nullable final List<Birthday> list) { _list = list; }

	@Override
	public void run() {
		//TODO Seb : Faire autre chose que afficher la date ...
		_list.stream().forEach(birthday -> System.out.println(birthday));
	}
}
