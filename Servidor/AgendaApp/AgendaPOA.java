package AgendaApp;


/**
* AgendaApp/AgendaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Agenda.idl
* Quinta-feira, 19 de Setembro de 2013 10h44min54s BRT
*/

public abstract class AgendaPOA extends org.omg.PortableServer.Servant
 implements AgendaApp.AgendaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("salvar", new java.lang.Integer (0));
    _methods.put ("atualizar", new java.lang.Integer (1));
    _methods.put ("apagar", new java.lang.Integer (2));
    _methods.put ("consultar", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // AgendaApp/Agenda/salvar
       {
         String nome = in.read_string ();
         String telefone = in.read_string ();
         int $result = (int)0;
         $result = this.salvar (nome, telefone);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // AgendaApp/Agenda/atualizar
       {
         String nome = in.read_string ();
         String telefone = in.read_string ();
         int $result = (int)0;
         $result = this.atualizar (nome, telefone);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // AgendaApp/Agenda/apagar
       {
         String nome = in.read_string ();
         int $result = (int)0;
         $result = this.apagar (nome);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // AgendaApp/Agenda/consultar
       {
         String nome = in.read_string ();
         String $result = null;
         $result = this.consultar (nome);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:AgendaApp/Agenda:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Agenda _this() 
  {
    return AgendaHelper.narrow(
    super._this_object());
  }

  public Agenda _this(org.omg.CORBA.ORB orb) 
  {
    return AgendaHelper.narrow(
    super._this_object(orb));
  }


} // class AgendaPOA
