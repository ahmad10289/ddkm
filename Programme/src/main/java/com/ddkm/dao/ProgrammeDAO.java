package com.ddkm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddkm.dto.ProgrammeArchiveDto;

@Repository
public class ProgrammeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
//	public List<ProgrammeArchiveDto> getAllProgrammes() {
//		Session session = sessionFactory.openSession();
//		String hql = "select new ProgrammeArchiveDto("
//				+ "P.programmePrimaryKey, "
//				+ "P.genre, "
//				+ "P.subject, "
//				+ "P.fileName, "
//				+ "P.producerName, "
//				+ "P.mediaNmumber, "
//				+ "P.mediaFormat, "
//				+ "P.editor, "
//				+ "P.editSuit, "
//				+ "P.programType,"
//				+ "elements(P.artists), "
//				+ "elements(P.guests), "
//				+ "elements(P.cameramen)) "
//				+ "FROM ProgrammeArchiveDto P";
//		Query query = session.createQuery(hql);
//		List<ProgrammeArchiveDto> results = query.list();
//		session.close();
//		return results;
//	}
	
	public List<ProgrammeArchiveDto> getAllProgrammes() {
		Session session = sessionFactory.openSession();
		String hql = "FROM ProgrammeArchiveDto";
		Query query = session.createQuery(hql);
		List<ProgrammeArchiveDto> results = query.list();
		session.close();
		return results;
	}
	
	public void saveProgrammes(List<ProgrammeArchiveDto> programmeArchiveDtoList) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			for (ProgrammeArchiveDto programmeArchiveDto : programmeArchiveDtoList) {
				programmeArchiveDto.setStatus("SUBMITTED");
				session.save(programmeArchiveDto);
			}
			session.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
			session.getTransaction().rollback();

		} finally {
		session.close();
		}
	}
	
	public void updateProgrammes(List<ProgrammeArchiveDto> programmeArchiveDtoList) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			for (ProgrammeArchiveDto programmeArchiveDto : programmeArchiveDtoList) {
				session.update(programmeArchiveDto);
			}
			session.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
			session.getTransaction().rollback();

		} finally {
		session.close();
		}
	}
	
	public void deleteProgrammes(List<ProgrammeArchiveDto> programmeArchiveDtoList) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			for (ProgrammeArchiveDto programmeArchiveDto : programmeArchiveDtoList) {
				session.delete(programmeArchiveDto);
			}
			session.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
			session.getTransaction().rollback();

		} finally {
		session.close();
		}
	}

}
