package AgendaApp;

/**
* AgendaApp/AgendaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Agenda.idl
* Quinta-feira, 19 de Setembro de 2013 10h44min54s BRT
*/

public final class AgendaHolder implements org.omg.CORBA.portable.Streamable
{
  public AgendaApp.Agenda value = null;

  public AgendaHolder ()
  {
  }

  public AgendaHolder (AgendaApp.Agenda initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = AgendaApp.AgendaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    AgendaApp.AgendaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return AgendaApp.AgendaHelper.type ();
  }

}
