class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
        self.before=None
        
class LRUCache:
    dic={}
    head=ListNode(-100000)
    tail=ListNode(-100000)
    head.next=tail
    tail.before=head
    cap=0
    survive=0
    # @param capacity, an integer
    def __init__(self, capacity):
        self.cap=capacity
    # @return an integer
    def get(self, key):
        if self.dic.has_key(key):
            value=self.dic[key]
            current=self.head
            currentt=self.tail
            while current.next.val!=key and currentt.before.val!=key:
                current=current.next
                currentt=currentt.before
                if current.next==self.tail:
                    break
                if currentt.before==self.head:
                    break
            if current.next.val==key:
                t=current.next
                current.next=t.next
                t.next.before=current
                u=self.head.next
                self.head.next=t
                t.before=self.head
                t.next=u
                u.before=t
            else:
                t=currentt.before
                currentt.before=t.before
                t.before.next=currentt
                u=self.head.next
                self.head.next=t
                t.before=self.head
                t.next=u
                u.before=t
            return value
        else:
            return -1
    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if self.dic.has_key(key):
            self.dic[key]=value
            current=self.head
            currentt=self.tail
            while current.next.val!=key and currentt.before.val!=key:
                current=current.next
                currentt=currentt.before
                if current.next==self.tail:
                    break
                if currentt.before==self.head:
                    break
            if current.next.val==key:
                t=current.next
                current.next=t.next
                t.next.before=current
                u=self.head.next
                self.head.next=t
                t.before=self.head
                t.next=u
                u.before=t
            else:
                t=currentt.before
                currentt.before=t.before
                t.before.next=currentt
                u=self.head.next
                self.head.next=t
                t.before=self.head
                t.next=u
                u.before=t
        else:
            # print self.survive,self.cap
            if self.survive<self.cap:
                self.dic[key]=value
                self.survive+=1
                t=ListNode(key)
                u=self.head.next
                self.head.next=t
                t.before=self.head
                u.before=t
                t.next=u
            else:
                times=len(self.dic)
                currentt=self.tail
                delval=currentt.before.val
                self.tail.before=None
                t=ListNode(key)
                u=self.head.next
                self.head.next=t
                t.before=self.head
                t.next=u
                u.before=t
                del self.dic[delval]
                self.dic[key]=value
                # print self.dic
    def traverse(self):
        current=self.head
        while current!=None:
            print current.val,"->"
            current=current.next
        
                
        
# l=LRUCache(3)
# l.set(1,20)
# l.set(1,30)
# l.set(1,20)
# l.set(2,23)
# l.set(3,30)
# l.set(2,23)
# l.get(4)
# l.get(1)
# l.get(2)
# l.set(2,23)
# l.set(1,40)
# l.set(4,21)
# l.traverse()
l=LRUCache(105)
l.set(33,219);l.get(39);l.set(96,56);l.get(129);l.get(115);l.get(112);l.set(3,280);l.get(40);l.set(85,193);l.set(10,10);l.set(100,136);l.set(12,66);l.set(81,261);l.set(33,58);l.get(3);l.set(121,308);l.set(129,263);l.get(105);l.set(104,38);l.set(65,85);l.set(3,141);l.set(29,30);l.set(80,191);l.set(52,191);l.set(8,300);l.get(136);l.set(48,261);l.set(3,193);l.set(133,193);l.set(60,183);l.set(128,148);l.set(52,176);l.get(48);l.set(48,119);l.set(10,241);l.get(124);l.set(130,127);l.get(61);l.set(124,27);l.get(94);l.set(29,304);l.set(102,314);l.get(110);l.set(23,49);l.set(134,12);l.set(55,90);l.get(14);l.get(104);l.set(77,165);l.set(60,160);l.get(117);l.set(58,30);l.get(54);l.get(136);l.get(128);l.get(131);l.set(48,114);l.get(136);l.set(46,51);l.set(129,291);l.set(96,207);l.get(131);l.set(89,153);l.set(120,154);l.get(111);l.get(47);l.get(5);l.set(114,157);l.set(57,82);l.set(113,106);l.set(74,208);l.get(56);l.get(59);l.get(100);l.get(132);l.set(127,202);l.get(75);l.set(102,147);l.get(37);l.set(53,79);l.set(119,220);l.get(47);l.get(101);l.get(89);l.get(20);l.get(93);l.get(7);l.set(48,109);l.set(71,146);l.get(43);l.get(122);l.set(3,160);l.get(17);l.set(80,22);l.set(80,272);l.get(75);l.get(117);l.set(76,204);l.set(74,141);l.set(107,93);l.set(34,280);l.set(31,94);l.get(132);l.set(71,258);l.get(61);l.get(60);l.set(69,272);l.get(46);l.set(42,264);l.set(87,126);l.set(107,236);l.set(131,218);l.get(79);l.set(41,71);l.set(94,111);l.set(19,124);l.set(52,70);l.get(131);l.get(103);l.get(81);l.get(126);l.set(61,279);l.set(37,100);l.get(95);l.get(54);l.set(59,136);l.set(101,219);l.set(15,248);l.set(37,91);l.set(11,174);l.set(99,65);l.set(105,249);l.get(85);l.set(108,287);l.set(96,4);l.get(70);l.get(24);l.set(52,206);l.set(59,306);l.set(18,296);l.set(79,95);l.set(50,131);l.set(3,161);l.set(2,229);l.set(39,183);l.set(90,225);l.set(75,23);l.set(136,280);l.get(119);l.set(81,272);l.get(106);l.get(106);l.get(70);l.set(73,60);l.set(19,250);l.set(82,291);l.set(117,53);l.set(16,176);l.get(40);l.set(7,70);l.set(135,212);l.get(59);l.set(81,201);l.set(75,305);l.get(101);l.set(8,250);l.get(38);l.set(28,220);l.get(21);l.set(105,266);l.get(105);l.get(85);l.get(55);l.get(6);l.set(78,83);l.get(126);l.get(102);l.get(66);l.set(61,42);l.set(127,35);l.set(117,105);l.get(128);l.get(102);l.get(50);l.set(24,133);l.set(40,178);l.set(78,157);l.set(71,22);l.get(25);l.get(82);l.get(129);l.set(126,12);l.get(45);l.get(40);l.get(86);l.get(100);l.set(30,110);l.get(49);l.set(47,185);l.set(123,101);l.get(102);l.get(5);l.set(40,267);l.set(48,155);l.get(108);l.get(45);l.set(14,182);l.set(20,117);l.set(43,124);l.get(38);l.set(77,158);l.get(111);l.get(39);l.set(69,126);l.set(113,199);l.set(21,216);l.get(11);l.set(117,207);l.get(30);l.set(97,84);l.get(109);l.set(99,218);l.get(109);l.set(113,1);l.get(62);l.set(49,89);l.set(53,311);l.get(126);l.set(32,153);l.set(14,296);l.get(22);l.set(14,225);l.get(49);l.get(75);l.set(61,241);l.get(7);l.get(6);l.get(31);l.set(75,15);l.get(115);l.set(84,181);l.set(125,111);l.set(105,94);l.set(48,294);l.get(106);l.get(61);l.set(53,190);l.get(16);l.set(12,252);l.get(28);l.set(111,122);l.get(122);l.set(10,21);l.get(59);l.get(72);l.get(39);l.get(6);l.get(126);l.set(131,177);l.set(105,253);l.get(26);l.set(43,311);l.get(79);l.set(91,32);l.set(7,141);l.get(38);l.get(13);l.set(79,135);l.get(43);l.get(94);l.set(80,182);l.get(53);l.set(120,309);l.set(3,109);l.get(97);l.set(9,128);l.set(114,121);l.get(56);l.get(56);l.set(124,86);l.set(34,145);l.get(131);l.get(78);l.set(86,21);l.get(98);l.set(115,164);l.set(47,225);l.get(95);l.set(89,55);l.set(26,134);l.set(8,15);l.get(11);l.set(84,276);l.set(81,67);l.get(46);l.get(39);l.get(92);l.get(96);l.set(89,51);l.set(136,240);l.get(45);l.get(27);l.set(24,209);l.set(82,145);l.get(10);l.set(104,225);l.set(120,203);l.set(121,108);l.set(11,47);l.get(89);l.set(80,66);l.get(16);l.set(95,101);l.get(49);l.get(1);l.set(77,184);l.get(27);l.set(74,313);l.set(14,118);l.get(16);l.get(74);l.set(88,251);l.get(124);l.set(58,101);l.set(42,81);l.get(2);l.set(133,101);l.get(16);l.set(1,254);l.set(25,167);l.set(53,56);l.set(73,198);l.get(48);l.get(30);l.get(95);l.set(90,102);l.set(92,56);l.set(2,130);l.set(52,11);l.get(9);l.get(23);l.set(53,275);l.set(23,258);l.get(57);l.set(136,183);l.set(75,265);l.get(85);l.set(68,274);l.set(15,255);l.get(85);l.set(33,314);l.set(101,223);l.set(39,248);l.set(18,261);l.set(37,160);l.get(112);l.get(65);l.set(31,240);l.set(40,295);l.set(99,231);l.get(123);l.set(34,43);l.get(87);l.get(80);l.set(47,279);l.set(89,299);l.get(72);l.set(26,277);l.set(92,13);l.set(46,92);l.set(67,163);l.set(85,184);l.get(38);l.set(35,65);l.get(70);l.get(81);l.set(40,65);l.get(80);l.set(80,23);l.set(76,258);l.get(69);l.get(133);l.set(123,196);l.set(119,212);l.set(13,150);l.set(22,52);l.set(20,105);l.set(61,233);l.get(97);l.set(128,307);l.get(85);l.get(80);l.get(73);l.get(30);l.set(46,44);l.get(95);l.set(121,211);l.set(48,307);l.get(2);l.set(27,166);l.get(50);l.set(75,41);l.set(101,105);l.get(2);l.set(110,121);l.set(32,88);l.set(75,84);l.set(30,165);l.set(41,142);l.set(128,102);l.set(105,90);l.set(86,68);l.set(13,292);l.set(83,63);l.set(5,239);l.get(5);l.set(68,204);l.get(127);l.set(42,137);l.get(93);l.set(90,258);l.set(40,275);l.set(7,96);l.get(108);l.set(104,91);l.get(63);l.get(31);l.set(31,89);l.get(74);l.get(81);l.set(126,148);l.get(107);l.set(13,28);l.set(21,139);l.get(114);l.get(5);l.get(89);l.get(133);l.get(20);l.set(96,135);l.set(86,100);l.set(83,75);l.get(14);l.set(26,195);l.get(37);l.set(1,287);l.get(79);l.get(15);l.get(6);l.set(68,11);l.get(52);l.set(124,80);l.set(123,277);l.set(99,281);l.get(133);l.get(90);l.get(45);l.get(127);l.set(9,68);l.set(123,6);l.set(124,251);l.set(130,191);l.set(23,174);l.set(69,295);l.get(32);l.get(37);l.set(1,64);l.set(48,116);l.get(68);l.set(117,173);l.set(16,89);l.get(84);l.set(28,234);l.get(129);l.get(89);l.get(55);l.get(83);l.set(99,264);l.get(129);l.get(84);l.get(14);l.set(26,274);l.get(109);l.get(110);l.set(96,120);l.set(128,207);l.get(12);l.set(99,233);l.set(20,305);l.set(26,24);l.set(102,32);l.get(82);l.set(16,30);l.set(5,244);l.get(130);l.set(109,36);l.set(134,162);l.set(13,165);l.set(45,235);l.set(112,80);l.get(6);l.set(34,98);l.set(64,250);l.set(18,237);l.set(72,21);l.set(42,105);l.set(57,108);l.set(28,229);l.get(83);l.set(1,34);l.set(93,151);l.set(132,94);l.set(18,24);l.set(57,68);l.set(42,137);l.get(35);l.get(80);l.set(10,288);l.get(21);l.get(115);l.get(131);l.get(30);l.get(43);l.set(97,262);l.set(55,146);l.set(81,112);l.set(2,212);l.set(5,312);l.set(82,107);l.set(14,151);l.get(77);l.set(60,42);l.set(90,309);l.get(90);l.set(131,220);l.get(86);l.set(106,85);l.set(85,254);l.get(14);l.set(66,262);l.set(88,243);l.get(3);l.set(50,301);l.set(118,91);l.get(25);l.get(105);l.get(100);l.get(89);l.set(111,152);l.set(65,24);l.set(41,264);l.get(117);l.get(117);l.set(80,45);l.get(38);l.set(11,151);l.set(126,203);l.set(128,59);l.set(6,129);l.get(91);l.set(118,2);l.set(50,164);l.get(74);l.get(80);l.set(48,308);l.set(109,82);l.set(3,48);l.set(123,10);l.set(59,249);l.set(128,64);l.set(41,287);l.set(52,278);l.set(98,151);l.get(12);l.get(25);l.set(18,254);l.set(24,40);l.get(119);l.set(66,44);l.set(61,19);l.set(80,132);l.set(62,111);l.get(80);l.set(57,188);l.get(132);l.get(42);l.set(18,314);l.get(48);l.set(86,138);l.get(8);l.set(27,88);l.set(96,178);l.set(17,104);l.set(112,86);l.get(25);l.set(129,119);l.set(93,44);l.get(115);l.set(33,36);l.set(85,190);l.get(10);l.set(52,182);l.set(76,182);l.get(109);l.get(118);l.set(82,301);l.set(26,158);l.get(71);l.set(108,309);l.set(58,132);l.set(13,299);l.set(117,183);l.get(115);l.get(89);l.get(42);l.set(11,285);l.set(30,144);l.get(69);l.set(31,53);l.get(21);l.set(96,162);l.set(4,227);l.set(77,120);l.set(128,136);l.get(92);l.set(119,208);l.set(87,61);l.set(9,40);l.set(48,273);l.get(95);l.get(35);l.set(62,267);l.set(88,161);l.get(59);l.get(85);l.set(131,53);l.set(114,98);l.set(90,257);l.set(108,46);l.get(54);l.set(128,223);l.set(114,168);l.set(89,203);l.get(100);l.get(116);l.get(14);l.set(61,104);l.set(44,161);l.set(60,132);l.set(21,310);l.get(89);l.set(109,237);l.get(105);l.get(32);l.set(78,101);l.set(14,71);l.set(100,47);l.set(102,33);l.set(44,29);l.get(85);l.get(37);l.set(68,175);l.set(116,182);l.set(42,47);l.get(9);l.set(64,37);l.set(23,32);l.set(11,124);l.set(130,189);l.get(65);l.set(33,219);l.set(79,253);l.get(80);l.get(16);l.set(38,18);l.set(35,67);l.get(107);l.get(88);l.set(37,13);l.set(71,188);l.get(35);l.set(58,268);l.set(18,260);l.set(73,23);l.set(28,102);l.get(129);l.get(88);l.get(65);l.get(80);l.set(119,146);l.get(113);l.get(62);l.set(123,138);l.set(18,1);l.set(26,208);l.get(107);l.get(107);l.set(76,132);l.set(121,191);l.get(4);l.get(8);l.get(117);l.set(11,118);l.get(43);l.get(69);l.get(136);l.set(66,298);l.get(25);l.get(71);l.get(100);l.set(26,141);l.set(53,256);l.set(111,205);l.set(126,106);l.get(43);l.set(14,39);l.set(44,41);l.set(23,230);l.get(131);l.get(53);l.set(104,268);l.get(30);l.set(108,48);l.set(72,45);l.get(58);l.get(46);l.set(128,301);l.get(71);l.get(99);l.get(113);l.get(121);l.set(130,122);l.set(102,5);l.set(111,51);l.set(85,229);l.set(86,157);l.set(82,283);l.set(88,52);l.set(136,105);l.get(40);l.get(63);l.set(114,244);l.set(29,82);l.set(83,278);l.get(131);l.set(56,33);l.get(123);l.get(11);l.get(119);l.set(119,1);l.set(48,52);l.get(47);l.set(127,136);l.set(78,38);l.set(117,64);l.set(130,134);l.set(93,69);l.set(70,98);l.get(68);l.set(4,3);l.set(92,173);l.set(114,65);l.set(7,309);l.get(31);l.set(107,271);l.set(110,69);l.get(45);l.set(35,288);l.get(20);l.set(38,79);l.get(46);l.set(6,123);l.get(19);l.set(84,95);l.get(76);l.set(71,31);l.set(72,171);l.set(35,123);l.get(32);l.set(73,85);l.get(94);l.get(128);l.get(28);l.get(38);l.get(109);l.set(85,197);l.set(10,41);l.set(71,50);l.get(128);l.set(3,55);l.set(15,9);l.set(127,215);l.get(17);l.get(37);l.set(111,272);l.set(79,169);l.set(86,206);l.set(40,264);l.get(134);l.set(16,207);l.set(27,127);l.set(29,48);l.set(32,122);l.set(15,35);l.set(117,36);l.get(127);l.get(36);l.set(72,70);l.set(49,201);l.set(89,215);l.set(134,290);l.set(77,64);l.set(26,101);l.get(99);l.set(36,96);l.set(84,129);l.set(125,264);l.get(43);l.get(38);l.set(24,76);l.set(45,2);l.set(32,24);l.set(84,235);l.set(16,240);l.set(17,289);l.set(49,94);l.set(90,54);l.set(88,199);l.get(23);l.set(87,19);l.set(11,19);l.get(24);l.get(57);l.get(4);l.get(40);l.set(133,286);l.set(127,231);l.get(51);l.set(52,196);l.get(27);l.get(10);l.get(93);l.set(115,143);l.set(62,64);l.set(59,200);l.set(75,85);l.set(7,93);l.set(117,270);l.set(116,6);l.get(32);l.get(135);l.set(2,140);l.set(23,1);l.set(11,69);l.set(89,30);l.set(27,14);l.get(100);l.get(61);l.set(99,41);l.set(88,12);l.get(41);l.set(52,203);l.get(65);l.set(62,78);l.set(104,276);l.set(105,307);l.get(7);l.set(23,123);l.get(22);l.set(35,299);l.get(69);l.get(11);l.set(14,112);l.get(115);l.get(112);l.get(108);l.set(110,165);l.set(83,165);l.set(36,260);l.set(54,73);l.get(36);l.set(93,69);l.get(134);l.set(125,96);l.set(74,127);l.set(110,305);l.set(92,309);l.set(87,45);l.set(31,266);l.get(10);l.set(114,206);l.set(49,141);l.get(82);l.set(92,3);l.set(91,160);l.get(41);l.set(60,147);l.set(36,239);l.set(23,296);l.set(134,120);l.get(6);l.set(5,283);l.set(117,68);l.get(35);l.get(120);l.set(44,191);l.set(121,14);l.set(118,113);l.set(84,106);l.get(23);l.set(15,240);l.get(37);l.set(52,256);l.set(119,116);l.set(101,7);l.set(14,157);l.set(29,225);l.set(4,247);l.set(8,112);l.set(8,189);l.set(96,220);l.get(104);l.set(72,106);l.set(23,170);l.set(67,209);l.set(70,39);l.get(18);l.get(6);l.get(34);l.set(121,157);l.get(16);l.get(19);l.set(83,283);l.set(13,22);l.set(33,143);l.set(88,133);l.get(88);l.set(5,49);l.get(38);l.get(110);l.get(67);l.set(23,227);l.get(68);l.get(3);l.set(27,265);l.get(31);l.set(13,103);l.get(116);l.set(111,282);l.set(43,71);l.get(134);l.set(70,141);l.get(14);l.get(119);l.get(43);l.get(122);l.set(38,187);l.set(8,9);l.get(63);l.set(42,140);l.get(83);l.get(92);l.get(106);l.get(28);l.set(57,139);l.set(36,257);l.set(30,204);l.get(72);l.set(105,243);l.get(16);l.set(74,25);l.get(22);l.set(118,144);l.get(133);l.get(71);l.set(99,21);l.get(26);l.get(35);l.set(89,209);l.set(106,158);l.set(76,63);l.set(112,216);l.get(128);l.get(54);l.set(16,165);l.set(76,206);l.set(69,253);l.get(23);l.set(54,111);l.get(80);l.set(111,72);l.set(95,217);l.get(118);l.set(4,146);l.get(47);l.set(108,290);l.get(43);l.set(70,8);l.get(117);l.get(121);l.set(42,220);l.get(48);l.get(32);l.set(68,213);l.set(30,157);l.set(62,68);l.get(58);l.set(125,283);l.set(132,45);l.get(85);l.get(92);l.set(23,257);l.get(74);l.set(18,256);l.get(90);l.set(10,158);l.set(57,34);l.get(27);l.get(107)]
