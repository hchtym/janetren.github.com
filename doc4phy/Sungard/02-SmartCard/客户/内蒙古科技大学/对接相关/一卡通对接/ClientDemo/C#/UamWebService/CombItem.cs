using System;
using System.Collections.Generic;
using System.Text;

namespace UamWebService
{
    class CombItem : System.Object
    {
        public String caption;
        public long itemValue;
        public CombItem(String caption, long itemValue)
        {
            this.caption = caption;
            this.itemValue = itemValue;
        }
        public override string ToString()
        {
            return caption;
        }
    }
}
